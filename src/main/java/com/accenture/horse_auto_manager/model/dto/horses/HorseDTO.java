package com.accenture.horse_auto_manager.model.dto.horses;

import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import com.accenture.horse_auto_manager.model.dto.person.StablemanDTO;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalTime;
import java.util.List;

@Data
public class HorseDTO {

    private Long guid;
    private String name;
    private String nickname;
    private String color;
    private String breedName;
    private String type;   //private DoctorDTO doctorname; aber nicht das ganze Objekt >> Kreisschluss
    //private LocalTime eligibleEatingTimes;
    //private String doctorName;
    //private String stablemanName;
    private Long chip_id;
   // private List<StablemanDTO> stablemanDTOList;

    // typ-rasse-
}
