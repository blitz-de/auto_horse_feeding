package com.accenture.horse_auto_manager.model.domain.person;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tab_doctor")
@Getter
@Setter
@NoArgsConstructor
public class DoctorEntity extends PersonEntity {

   /* @Id
    @Column(name = "doctor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long doctorID;

    */
    @Column(name = "medical_degree")
    private String medicalDegree;

    @OneToMany(mappedBy = "doctor")
    //@JsonIgnore
    private Set<HorseEntity> horses = new HashSet<>();

/*
    public DoctorEntity(Long personID, String firstname, String lastname, String address, String plz,
                        String gender, String city, String age, String occupation, String medicalDegree){
        super(personID, firstname,lastname,address,plz,gender,city,age, occupation);
        this.medicalDegree = medicalDegree;
    }
 */
}
