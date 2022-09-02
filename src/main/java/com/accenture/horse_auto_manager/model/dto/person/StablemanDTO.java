package com.accenture.horse_auto_manager.model.dto.person;

import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Data
public class StablemanDTO extends PersonDTO {

    //private Long stablemanID;
    private Long id;
    private List<HorseDTO> horses;

}
