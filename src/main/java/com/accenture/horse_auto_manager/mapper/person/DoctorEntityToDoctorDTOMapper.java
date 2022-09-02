package com.accenture.horse_auto_manager.mapper.person;

import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorEntityToDoctorDTOMapper {

    DoctorDTO mapDoctorEntityToDoctorDTO(DoctorEntity source);



}
