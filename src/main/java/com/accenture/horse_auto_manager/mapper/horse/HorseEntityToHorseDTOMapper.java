package com.accenture.horse_auto_manager.mapper.horse;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorseEntityToHorseDTOMapper {

    //@Mapping(target = "doctorName", source = "source.doctor.lastname")
    //@Mapping(target = "stablemanName", source = "source.stableman.lastname")
    @Mapping(target = "chip_id", source = "source.rfidChip.chip_id")
    HorseDTO mapHorseEntityToHorseDTO(HorseEntity source);

}
