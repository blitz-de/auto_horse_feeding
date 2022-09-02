package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.food.FoodDTO;
import com.accenture.horse_auto_manager.services.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/food", produces = {MediaType.APPLICATION_JSON_VALUE})
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/all")
    public ResponseEntity<List<FoodDTO>> getAllFood(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodService.getAllFoodService());
    }

    @GetMapping("/{food_id}")
    public ResponseEntity<FoodDTO> getFoodById
            (@PathVariable("food_id") Long food_id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodService.getFoodByIdService(food_id));
    }

    @PostMapping("/create")
    public ResponseEntity<FoodDTO> postFoodDTO(@RequestBody FoodDTO foodDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodService.createFood(foodDTO));
    }
}
