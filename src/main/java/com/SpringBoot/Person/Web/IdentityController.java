package com.SpringBoot.Person.Web;

import com.SpringBoot.Person.Model.Identity;
import com.SpringBoot.Person.Service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("identity")
public class IdentityController {

    @Autowired
    IdentityService identityService;

    @GetMapping
    public ResponseEntity<List<Identity>> getAllIdentity(){
        List<Identity> IdentityList = identityService.getAllIdentity();
        return ResponseEntity.ok(IdentityList);
    }

    @GetMapping("{id}")
    public Identity getIdentity(@PathVariable Long id){
        return identityService.getIdentity(id);
    }

    @PostMapping
    public  Identity createIdentity(@RequestBody Identity identity, @RequestParam(value = "personId")Long personId){
        return identityService.createIdentity(identity,personId);
    }

    @PutMapping("{id}")
    public Identity updateIdentity(@PathVariable Long id, @RequestBody Identity identity){
        return identityService.updateIdentity(id,identity);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteIdentity(@PathVariable Long id){
        identityService.deleteIdentity(id);
        return ResponseEntity.ok("Delete Success");
    }


}
