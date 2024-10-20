package com.SpringBoot.Person.Web;


import com.SpringBoot.Person.Model.Person;
import com.SpringBoot.Person.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping("{id}")
    public  Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @GetMapping("{identity}")
    public List<Person> findPersonWithIdentity(@RequestParam String name){
        return personService.findPersonWithIdentity(name);
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PutMapping("{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return  ResponseEntity.ok("Delete Success");
    }
}
