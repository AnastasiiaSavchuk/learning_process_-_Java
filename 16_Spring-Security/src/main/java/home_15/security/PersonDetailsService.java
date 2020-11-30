package home_15.security;

import home_15.model.Person;
import home_15.model.PersonRole;
import home_15.reposetory.PersonRepository;
import home_15.reposetory.PersonRoleRepository;
import home_15.security.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String personName) throws UsernameNotFoundException {

        Person person = personRepository.findByPersonName(personName);
        if (Objects.isNull(person)) {
            throw new UsernameNotFoundException("No person with person name : " + personName);
        } else {
            List<String> roles = new ArrayList<>();
            List<PersonRole> personRoles = personRoleRepository.findPersonRolesByPersonId(person.getId());
            personRoles.forEach(personRole -> roles.add(personRole.getRole()));
            return new PersonDetails(roles, person);
        }
    }
}