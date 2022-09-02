package com.accenture.horse_auto_manager.services.person;

import com.accenture.horse_auto_manager.mapper.person.DoctorDTOToDoctorEntityMapper;
import com.accenture.horse_auto_manager.mapper.person.DoctorEntityToDoctorDTOMapper;
import com.accenture.horse_auto_manager.mapper.horse.HorseEntityToHorseDTOMapper;
import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.dto.person.DoctorDTO;
import com.accenture.horse_auto_manager.repositories.person.DoctorRepository;
import com.accenture.horse_auto_manager.services.horse.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorDTOToDoctorEntityMapper doctorDTOMapper;
    @Autowired
    DoctorEntityToDoctorDTOMapper doctorEntityMapper;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    HorseEntityToHorseDTOMapper horseEntityMapper;
    @Autowired
    HorseService horseService;
    public DoctorDTO createDoctor(DoctorDTO doctorDTO){
        DoctorEntity doctorEntity =doctorDTOMapper.mapDoctorDTOToDoctorEntity(doctorDTO);
        doctorEntity = doctorRepository.save(doctorEntity);
        return doctorEntityMapper.mapDoctorEntityToDoctorDTO(doctorEntity);
    }

    public DoctorDTO getDoctorById(Long doctor_id){

        DoctorEntity doctorEntity = doctorRepository.findById(doctor_id).get();

        return doctorEntityMapper.mapDoctorEntityToDoctorDTO(doctorEntity);

    }

    public DoctorDTO assignHorseToDoctor(Long horse_id, Long doctor_id) {
        DoctorEntity doctorEntity = doctorRepository.findById(doctor_id).get();
        HorseEntity horse = horseService.getHorseEntityById(horse_id);
        //doctorEntity = doctorDTOMapper.mapDoctorDTOToDoctorEntity(doctorEntity);


        /*
        1. doctorEntity.setHorse
         */
        // getHorseByID -- add Horse to HorseList
        doctorEntity.getHorses().add(horse);
        return doctorEntityMapper.mapDoctorEntityToDoctorDTO(doctorEntity);
    }

    public List<DoctorDTO> getAllDoctors() {
        List<DoctorDTO> doctorDTOList = new ArrayList<>();
        List<DoctorEntity> doctorEntityList = doctorRepository.findAll();

        doctorEntityList.forEach(doctorEntity -> doctorDTOList.add(doctorEntityMapper
                .mapDoctorEntityToDoctorDTO(doctorEntity)));

        return doctorDTOList;
    }
}
