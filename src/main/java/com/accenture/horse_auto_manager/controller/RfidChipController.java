package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.horses.RFIDChipDTO;
import com.accenture.horse_auto_manager.repositories.horses.RFIDRepository;
import com.accenture.horse_auto_manager.services.horse.RfidChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/chips")
public class RfidChipController {

    @Autowired
    RfidChipService rfidChipService;
    @Autowired
    RFIDRepository rfidRepository;

    @GetMapping("all")
    public ResponseEntity<List<RFIDChipDTO>> getAllChips() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(rfidChipService.getAllChipsService());
    }
    @GetMapping("/chip/{chip_id}")
    public ResponseEntity<?> getChipById(Long chip_id) {

        if(rfidChipService.ifChipIDDoNotExist(chip_id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("This Chip-ID doesn't exist.");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(rfidChipService.getChipByIDService(chip_id));
    }
}