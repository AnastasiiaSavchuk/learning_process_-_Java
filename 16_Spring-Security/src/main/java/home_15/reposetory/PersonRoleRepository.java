package home_15.reposetory;

import home_15.model.PersonRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRoleRepository extends CrudRepository<PersonRole,String> {

    List<PersonRole> findPersonRolesByPersonId(String personId);
}