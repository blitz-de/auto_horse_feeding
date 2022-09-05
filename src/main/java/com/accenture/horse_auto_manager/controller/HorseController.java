package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.horses.RFIDRepository;
import com.accenture.horse_auto_manager.services.horse.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/horse", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HorseController {

    @Autowired
    private HorseService horseService;
    @Autowired
    RFIDRepository rfidRepository;
    @GetMapping("/all")
    public ResponseEntity<List<HorseDTO>> getHorses(){
        return ResponseEntity.status(HttpStatus.OK).body(horseService.getHorses());
    }

    @GetMapping("/{horse_id}")
    public ResponseEntity<HorseDTO> getHorses(@PathVariable Long horse_id){
        return ResponseEntity.status(HttpStatus.OK).body(horseService.getHorseById(horse_id));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createHorse(@RequestBody HorseDTO horseDTO){

        /*
        if(!horseService.ifChipDoNotExistInStorage(horseDTO.getChip_id())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("You don't have a chip with this ID in your storage. " +
                            "Please choose an existing chip ID.");
        }
         */

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(horseService.createHorse(horseDTO));
    }

    @PutMapping("/{horse_id}/doctor/{doctor_id}")
    public ResponseEntity<HorseDTO> assignDoctorToHorse(
            @PathVariable Long horse_id,
            @PathVariable Long doctor_id
    ) {
        HorseDTO horseDTO = horseService.assignDoctorToHorse(doctor_id, horse_id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(horseDTO);
    }

    @PutMapping("/{horse_id}/stableman/{stableman_id}")
    public ResponseEntity<HorseDTO> assignStablemanToHorse(
            @PathVariable Long horse_id,
            @PathVariable Long stableman_id
    ) {
        HorseDTO horseDTO = horseService.assignStablemanToHorse(stableman_id, horse_id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(horseDTO);
    }

    /**
     * TODO:
     *      1. implement assignFoodToHorse(food_id, horse_id)
     *      2.
     * Only preferred Food by a specific horse_id is assigned to them.
     * @param horse_id
     * @param food_id
     * @return
     */
    @PutMapping("/{horse_id}/food/{food_id}")
    public ResponseEntity<HorseDTO> assignFoodToHorse(
            @PathVariable Long horse_id,
            @PathVariable Long food_id
    ) {
        HorseDTO horseDTO = horseService.assignFoodToHorseService(food_id, horse_id);
                /*
        is the hourse sick?
        if (hourse.isSick()){ horseService.getMedicineById(horse.getMedicine(HorseDTO.))}
         */
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(horseDTO);
    }

    @PutMapping("/{horse_id}/medicine/{medicine_id}")
    public ResponseEntity<HorseDTO> assignMedicineToHorse(
            @PathVariable Long horse_id,
            @PathVariable Long medicine_id
    ) {
        HorseDTO horseDTO = horseService.assignMedicineToHorseService(medicine_id, horse_id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(horseDTO);
    }
    @DeleteMapping("/{horse_id}")
    public ResponseEntity<String> deleteHorse(@PathVariable("horse_id") Long horse_id){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(horseService.removeHorse(horse_id));
    }

}
