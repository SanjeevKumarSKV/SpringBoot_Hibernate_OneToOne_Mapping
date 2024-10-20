package com.SpringBoot.Person.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "identity", schema = "person_schema")
public class Identity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long aadhaarno;

    @OneToOne
    @JoinColumn(name = "person_Id")
    private Person person;
}
