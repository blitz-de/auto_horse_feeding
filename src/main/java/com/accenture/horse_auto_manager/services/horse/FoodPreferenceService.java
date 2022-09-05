package com.accenture.horse_auto_manager.services.horse;

import com.accenture.horse_auto_manager.mapper.horse.HorseDTOToIHorseEntityMapper;
import com.accenture.horse_auto_manager.mapper.horse.HorseEntityToHorseDTOMapper;
import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.food.FoodRepository;
import com.accenture.horse_auto_manager.repositories.horses.HorseRepository;
import com.accenture.horse_auto_manager.services.food.TimedEligibleFoodService;
import com.accenture.horse_auto_manager.services.horse.interfaces.IFeedingPreference;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoodPreferenceService implements IFeedingPreference {

    LocalTime breakfast = LocalTime.parse("06:00:00");
    LocalTime launch = LocalTime.parse("11:00:00");
    LocalTime dinner = LocalTime.parse("17:00:00");
    LocalTime sleepTime = LocalTime.parse("21:00:00");
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    HorseRepository horseRepository;
    @Autowired
    HorseEntityToHorseDTOMapper horseDTOMapper;
    @Autowired TimedEligibleFoodService timedEligibleFoodService;
    @Autowired ReleaseFoodService releaseFoodService;
    public String feed(Long horse_id) {

        HorseEntity horseEntity = horseRepository.findById(horse_id).get();
        HorseDTO horseDTO = horseDTOMapper.mapHorseEntityToHorseDTO(horseEntity);
        /*
        Brown horse eats launch: -200 oats
         */
        String horseColor = horseDTO.getColor();
        List<String> preference = feedingPreference(horseColor);
        // if (horseColor.equals("brown")){
        preference.forEach(food -> {
            if(timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), launch)){
                // if openForBreakfast etc.
                if (releaseFoodService.openForBreakfast
                        (horseDTO.getChip_id(),horseDTO)){
                    horseEatsFromFoodContainer(horseDTO, food);
                }

            }
            if (timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), dinner)){
                if (releaseFoodService.openForBreakfast
                        (horseDTO.getChip_id(),horseDTO)) {
                    horseEatsFromFoodContainer(horseDTO, food);
                }
            }
            if (timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), sleepTime)){
                if (releaseFoodService.openForBreakfast
                        (horseDTO.getChip_id(),horseDTO)) {
                    horseEatsFromFoodContainer(horseDTO, food);
                }
            }
        });
        return "horse didn't eat!";
    }

    // Each horse with a different color has different food preference
    public List<String> feedingPreference(String horseColor) {
        List foodPreference = new ArrayList<>();

        if (horseColor.equals("brown")){
            foodPreference = Arrays.asList("oat", "hay", "pressed-grass");

            return foodPreference;
        }
        else if(horseColor.equals("white")){
            foodPreference =Arrays.asList("hay", "pressed-grass");

            return foodPreference;
        }
        else if(horseColor.equals("black")){
            foodPreference =Arrays.asList("oat", "pressed-grass");

            return foodPreference;
        }
        return foodPreference;
    }
    public String horseEatsFromFoodContainer(HorseDTO horse, String foodtype) {

        if (foodtype.equals("oat")){
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 200;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
            return "horse has eaten some oat!";
        }
        else if (foodtype.equals("hay")){
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 300;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
            return "horse has eaten some hay!";
        } else if (foodtype.equals("Pressed-Grass")) {
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 100;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
            return "horse has eaten some pressed-grass!";
        }
        return "horse didn't eat anything from the container!";
    }
}
