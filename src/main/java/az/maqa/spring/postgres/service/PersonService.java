package az.maqa.spring.postgres.service;

import az.maqa.spring.postgres.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);

    List<PersonDto> getAllPerson();


}
