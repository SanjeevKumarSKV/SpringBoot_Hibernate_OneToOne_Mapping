package com.SpringBoot.Person.Service;


import com.SpringBoot.Person.Dao.IdentityRepository;
import com.SpringBoot.Person.Dao.PersonRepository;
import com.SpringBoot.Person.Model.Identity;
import com.SpringBoot.Person.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdentityService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    IdentityRepository identityRepository;

    public List<Identity> getAllIdentity(){
        return identityRepository.findAll();
    }

    public Identity getIdentity(Long id){
        Optional<Identity> Iden = identityRepository.findById(id);
        return Iden.orElse(null);
    }

    public Identity createIdentity(Identity identity, Long personId){
        Person person = personRepository.findById(personId).orElse(new Person());
        identity.setPerson(person);
        return identityRepository.save(identity);
    }

    public Identity updateIdentity(Long id, Identity identity){
        boolean IdentityExist = identityRepository.existsById(id);

        if (IdentityExist) {
            return identityRepository.save(identity);
        }
        return null;
    }

    public void deleteIdentity(Long id) {
        boolean IdentityExist = identityRepository.existsById(id);

        if (IdentityExist) {
            identityRepository.deleteById(id);
        }
    }
}
