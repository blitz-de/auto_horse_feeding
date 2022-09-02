package com.accenture.horse_auto_manager.mapper.horse;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorseDTOToIHorseEntityMapper {


    HorseEntity mapHorseDTOToHorseEntity(HorseDTO source);

}
