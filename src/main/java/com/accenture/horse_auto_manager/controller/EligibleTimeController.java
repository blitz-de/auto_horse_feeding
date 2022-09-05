package com.accenture.horse_auto_manager.controller;


import com.accenture.horse_auto_manager.services.food.TimedEligibleFoodService;
import com.accenture.horse_auto_manager.services.horse.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/api/eating-time", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EligibleTimeController {

    @Autowired
    TimedEligibleFoodService timedEligibleFoodService;

    @Autowired
    HorseService horseService;

    @GetMapping("/horse/all")
    public ResponseEntity<?> getHorsesToEatAtTime
            (@RequestParam("time") String localTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss");
        //LocalDate localDate = LocalDate.parse(date, formatter);
        LocalTime localTime2 = LocalTime.parse(localTime);
        if (localTime2.isAfter(LocalTime.parse("22:00:00"))
        || (localTime2.isAfter(LocalTime.parse("00:00:00"))
                && localTime2.isBefore(LocalTime.parse("07:00:00")))){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body("This is not an eligible time.");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(timedEligibleFoodService.getHorsesByLocalTime(localTime2));
    }
}
