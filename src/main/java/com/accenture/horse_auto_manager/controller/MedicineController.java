package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.food.MedicineDTO;
import com.accenture.horse_auto_manager.services.food.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/medicine", produces = {MediaType.APPLICATION_JSON_VALUE})
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/all")
    public ResponseEntity<List<MedicineDTO>> getAllMedicine(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicineService.getAllMedicineService());
    }

    @GetMapping("/{medicine_id}")
    public ResponseEntity<MedicineDTO> getMedicineById
            (@PathVariable("medicine_id") Long medicine_id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicineService.getMedicineByIdService(medicine_id));
    }

    @PostMapping("/create")
    public ResponseEntity<MedicineDTO> postMedicineDTO(@RequestBody MedicineDTO medicineDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicineService.createMedicine(medicineDTO));
    }

    @PostMapping("/add-to-storage/{medicine_id}")
    public ResponseEntity<MedicineDTO> addMedicineToStorage
            (@PathVariable("medicine") Long medicine_id,
                                                    @RequestParam("add-medicine") Long addMedicine){
        return ResponseEntity.status(HttpStatus.OK)
                .body(medicineService.addMedicineToStorageById(medicine_id, addMedicine));
    }
}
