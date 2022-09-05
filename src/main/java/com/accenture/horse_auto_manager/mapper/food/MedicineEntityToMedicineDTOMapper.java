package com.accenture.horse_auto_manager.mapper.food;


import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;
import com.accenture.horse_auto_manager.model.dto.food.MedicineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicineEntityToMedicineDTOMapper {

    MedicineDTO mapMedicineEntityToMedicineDTOMapper(MedicineEntity source);

}
