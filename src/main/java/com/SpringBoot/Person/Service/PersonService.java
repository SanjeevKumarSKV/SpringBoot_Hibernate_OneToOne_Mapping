package com.SpringBoot.Person.Service;


import com.SpringBoot.Person.Dao.PersonRepository;
import com.SpringBoot.Person.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person getPerson(Long id){
        Optional<Person> per = personRepository.findById(id);
        return per.orElse(null);
    }

    public List<Person> findPersonWithIdentity(String name){
        return personRepository.findPersonWithIdentity(name);
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person person){
        boolean PersonExist = personRepository.existsById(id);

        if (PersonExist){
            return personRepository.save(person);
        }
        return null;
    }

    public void deletePerson(Long id){
        boolean PersonExist = personRepository.existsById(id);

        if (PersonExist){
            personRepository.deleteById(id);
        }
    }
}
