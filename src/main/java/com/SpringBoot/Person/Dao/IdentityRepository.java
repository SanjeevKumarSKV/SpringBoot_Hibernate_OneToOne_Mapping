package com.SpringBoot.Person.Dao;

import com.SpringBoot.Person.Model.Identity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IdentityRepository extends JpaRepository<Identity, Long> {
}
