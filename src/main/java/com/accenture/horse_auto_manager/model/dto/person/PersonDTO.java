package com.accenture.horse_auto_manager.model.dto.person;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 14:00
@Data
public class PersonDTO {

    //private Long personID;
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
