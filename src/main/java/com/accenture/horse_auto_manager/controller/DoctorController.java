package com.accenture.horse_auto_manager.controller;

import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import com.accenture.horse_auto_manager.services.person.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doctors", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorService.createDoctor(doctorDTO));
    }


    @GetMapping("/{doctor_id}")
    public ResponseEntity<DoctorDTO> getDoctorByID(@PathVariable Long doctor_id){
        DoctorDTO doctorDto = doctorService.getDoctorById(doctor_id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctorDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(doctorService.getAllDoctors());
    }
}
