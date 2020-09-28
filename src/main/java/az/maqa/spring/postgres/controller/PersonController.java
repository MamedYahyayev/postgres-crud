package az.maqa.spring.postgres.controller;

import az.maqa.spring.postgres.dto.PersonDto;
import az.maqa.spring.postgres.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.save(personDto));
    }
}
