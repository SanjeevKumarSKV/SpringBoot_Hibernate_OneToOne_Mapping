package com.SpringBoot.Person.Dao;

import com.SpringBoot.Person.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

     @Query(
             value =
                     "select p.* "
                             + "from person e inner join identity a "
                             + "on p.id = a.person_Id "
                             + "where e.name > :name",
             nativeQuery = true)

     List<Person>findPersonWithIdentity(@Param("name") String name);
}
