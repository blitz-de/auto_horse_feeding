package com.accenture.horse_auto_manager.model.domain.person;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// 14:00
@MappedSuperclass
@Getter
@Setter
public abstract class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String plz;
    private String gender;
    private String city;
    private String age;
    private String occupation;

}
