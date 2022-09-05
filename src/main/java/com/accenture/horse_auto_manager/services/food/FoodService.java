package com.accenture.horse_auto_manager.services.food;

import com.accenture.horse_auto_manager.mapper.food.FoodDTOToFoodEntityMapper;
import com.accenture.horse_auto_manager.mapper.food.FoodEntityToFoodDTOMapper;
import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.dto.food.FoodDTO;
import com.accenture.horse_auto_manager.repositories.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodEntityToFoodDTOMapper foodEntityMapper;
    @Autowired
    FoodDTOToFoodEntityMapper foodDTOMapper;


    public void addFoodToFoodContainer(){

    }
    public List<FoodDTO> getAllFoodService(){
        List<FoodDTO> foodDTOList = new ArrayList<>();
        List<FoodEntity> foodEntityList = foodRepository.findAll();

        foodEntityList.forEach(foodEntity -> foodDTOList.add(
            foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity)));

        return foodDTOList;
    }

    public FoodDTO getFoodByIdService(Long food_id){
        FoodEntity foodEntity = foodRepository.findById(food_id).get();

        return foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity);
    }

    public FoodDTO createFood(FoodDTO foodDTO) {

        FoodEntity foodEntity = foodDTOMapper.mapFoodDTOToFoodEntityMapper(foodDTO);
        foodEntity = foodRepository.save(foodEntity);
        return foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity);
    }

    public FoodDTO addFoodToStorageById(Long food_id, Long addFood) {
        FoodEntity foodEntity = foodRepository.findById(food_id).get();
        FoodDTO foodDTO;
        Long addedFood;
        if (foodEntity.getFoodLeft() == null){
            foodEntity.setFoodLeft(0L);
        }
        if(foodEntity.getFoodName().equals("oat")) {
            addedFood = foodEntity.getFoodLeft() +addFood;
            foodEntity.setFoodLeft(addedFood);
            foodRepository.save(foodEntity);
            foodDTO = foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity);
            return foodDTO;
        }
        if(foodEntity.getFoodName().equals("hay")) {
            addedFood = foodEntity.getFoodLeft() +addFood;
            foodEntity.setFoodLeft(addedFood);
            foodRepository.save(foodEntity);
            foodDTO = foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity);
            return foodDTO;
        }
        if(foodEntity.getFoodName().equals("Pressed-Grass")) {
            addedFood = foodEntity.getFoodLeft() +addFood;
            foodEntity.setFoodLeft(addedFood);
            foodRepository.save(foodEntity);
            foodDTO = foodEntityMapper.mapFoodEntityToFoodDToMapper(foodEntity);
            return foodDTO;
        }
        return null;
    }
}
