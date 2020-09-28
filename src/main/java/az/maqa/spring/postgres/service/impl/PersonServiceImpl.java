package az.maqa.spring.postgres.service.impl;

import az.maqa.spring.postgres.dto.PersonDto;
import az.maqa.spring.postgres.entity.Address;
import az.maqa.spring.postgres.entity.Person;
import az.maqa.spring.postgres.repository.AddressRepository;
import az.maqa.spring.postgres.repository.PersonRepository;
import az.maqa.spring.postgres.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());

        Person savedPerson = personRepository.save(person);

        List<Address> addresses = new ArrayList<>();

        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(savedPerson);
            addresses.add(address);
        });
        addressRepository.saveAll(addresses);
        personDto.setId(savedPerson.getId());

        return personDto;
    }



    @Override
    public List<PersonDto> getAllPerson() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();
        persons.forEach(item -> {
            PersonDto personDto = new PersonDto();
            personDto.setId(item.getId());
            personDto.setName(item.getName());
            personDto.setSurname(item.getSurname());
            personDto.setAddresses(item.getAddresses().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));

            personDtoList.add(personDto);
        });

        return personDtoList;
    }


}
