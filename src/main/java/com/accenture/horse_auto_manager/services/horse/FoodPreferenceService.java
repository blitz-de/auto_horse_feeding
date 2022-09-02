package com.accenture.horse_auto_manager.services.horse;

import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.food.FoodRepository;
import com.accenture.horse_auto_manager.services.horse.interfaces.IFeedingPreference;
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

    TimedEligibleFoodService timedEligibleFoodService;
    public void feed(HorseDTO horseDTO) {

        /*
        Brown horse eats launch: -200 oats
         */
        String horseColor = horseDTO.getColor();
        List<String> preference = feedingPreference(horseColor);
        // if (horseColor.equals("brown")){
        preference.forEach(food -> {
            if(timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), launch)){
                horseEatsFromFoodContainer(horseDTO, food);
            }
            if (timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), dinner)){
                horseEatsFromFoodContainer(horseDTO, food);
            }
            if (timedEligibleFoodService.eatingTimeBetween(LocalTime.now(), sleepTime)){
                horseEatsFromFoodContainer(horseDTO, food);
            }
        });

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
    public void horseEatsFromFoodContainer(HorseDTO horse, String foodtype) {

        if (foodtype.equals("oat")){
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 200;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
        }
        else if (foodtype.equals("hay")){
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 300;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
        } else if (foodtype.equals("pressed-grass")) {
            FoodEntity foodEntity = foodRepository.findById(horse.getGuid()).get();
            Long foodLeftInGram = foodEntity.getFoodLeft() - 100;
            foodEntity.setFoodLeft(foodLeftInGram);
            foodRepository.save(foodEntity);
        }
        //return null;
    }
}
