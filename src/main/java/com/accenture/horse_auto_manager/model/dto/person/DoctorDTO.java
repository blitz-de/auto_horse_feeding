package com.accenture.horse_auto_manager.model.dto.person;

import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import lombok.Data;

import java.util.List;


@Data
public class DoctorDTO extends PersonDTO {

//    private Long doctorID;
    private Long id;
    private String medicalDegree;

    private List<HorseDTO> horses;


}
