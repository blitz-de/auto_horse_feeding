package com.accenture.horse_auto_manager.mapper.food;

import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;
import com.accenture.horse_auto_manager.model.dto.food.MedicineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface MedicineDTOToMedicineEntityMapper {

    MedicineEntity mapMedicineDTOToMedicineEntityMapper(MedicineDTO source);

}
