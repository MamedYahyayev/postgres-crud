package az.maqa.spring.postgres.repository;

import az.maqa.spring.postgres.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
