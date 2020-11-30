package home_15.reposetory;

import home_15.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,String> {

    Person findByPersonName (String personName);
}