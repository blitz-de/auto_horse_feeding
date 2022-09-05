package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.services.horse.FoodPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/feed-horse")
public class FeedController {



    @Autowired
    FoodPreferenceService foodPreferenceService;

    @PostMapping("{horse_id}")
    public ResponseEntity<String> feedHorseWithID(@PathVariable("horse_id") Long horse_id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(foodPreferenceService.feed(horse_id));
    }

}
