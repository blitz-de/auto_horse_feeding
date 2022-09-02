package com.accenture.horse_auto_manager.mapper.person;

import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface DoctorDTOToDoctorEntityMapper {

    DoctorEntity mapDoctorDTOToDoctorEntity(DoctorDTO source);
    
    //DoctorEntity mapDoctorDTOToDoctorEntity(DoctorEntity doctorEntity);
}
