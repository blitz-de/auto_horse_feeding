package com.accenture.horse_auto_manager.mapper.food;

import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.dto.food.FoodDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodEntityToFoodDTOMapper {


    FoodDTO mapFoodEntityToFoodDToMapper(FoodEntity source);


    //List<FoodDTO> mapFoodEntityToFoodDTOMapper(List<FoodEntity> source);
}
