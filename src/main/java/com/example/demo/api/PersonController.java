package com.example.demo.api;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(path="/com/example/demo/api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired // initiate personService argument
    public PersonController
            (PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(
           @RequestBody Person person) {
        personService.addPerson(person.getPhoneNum(),person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{phoneNum}")
    public Person getPersonByPhoneNum(@PathVariable("phoneNum") String phoneNum){
        return personService.selectPersonByPhoneNum(phoneNum)
                .orElse(null);
    }

    @DeleteMapping(path="{phoneNum}")
    public void deletePersonByPhoneNum(@PathVariable("phoneNum") String phoneNum){
        personService.deletePerson(phoneNum);
    }

    @PutMapping(path = "{phoneNum}")
    public void updatePersonByPhoneNum
            (@PathVariable String phoneNum, @RequestBody Person person){
        personService.updatePerson(phoneNum,person);
    }
}
