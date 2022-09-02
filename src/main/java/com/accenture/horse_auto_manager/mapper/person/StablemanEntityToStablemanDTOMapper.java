package com.accenture.horse_auto_manager.mapper.person;

import com.accenture.horse_auto_manager.model.domain.person.StablemanEntity;
import com.accenture.horse_auto_manager.model.dto.person.StablemanDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StablemanEntityToStablemanDTOMapper {


    StablemanDTO mapStablemanToStablemanDTO(StablemanEntity source);

}
