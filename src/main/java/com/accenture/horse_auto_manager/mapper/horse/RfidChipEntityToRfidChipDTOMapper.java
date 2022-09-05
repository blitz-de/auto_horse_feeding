package com.accenture.horse_auto_manager.mapper.horse;

import com.accenture.horse_auto_manager.model.domain.horses.RFIDChipEntity;
import com.accenture.horse_auto_manager.model.dto.horses.RFIDChipDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RfidChipEntityToRfidChipDTOMapper {


    RFIDChipDTO mapRfidChipEntityToRfidChipDTO(RFIDChipEntity source);

}
