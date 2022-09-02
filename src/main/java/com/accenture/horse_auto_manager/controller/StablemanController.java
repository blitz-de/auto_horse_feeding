package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import com.accenture.horse_auto_manager.model.dto.person.StablemanDTO;
import com.accenture.horse_auto_manager.services.horse.HorseService;
import com.accenture.horse_auto_manager.services.person.DoctorService;
import com.accenture.horse_auto_manager.services.person.StablemanService;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/stableman", produces = {MediaType.APPLICATION_JSON_VALUE})
public class StablemanController {

    @Autowired
    StablemanService stablemanService;

    @PostMapping("/create")
    public ResponseEntity<StablemanDTO> postStableman(@RequestBody StablemanDTO stablemanDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(stablemanService.createStableman(stablemanDTO));
    }


    @GetMapping("/{stableman_id}")
    public ResponseEntity<StablemanDTO> getStablemanByID(@PathVariable Long stableman_id){
        StablemanDTO stablemanDTO = stablemanService.getStablemanById(stableman_id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(stablemanDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<StablemanDTO>> getAllStablemen() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(stablemanService.getAllStablemen());
    }
}
