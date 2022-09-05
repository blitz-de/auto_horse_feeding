package com.accenture.horse_auto_manager.services.horse;

import com.accenture.horse_auto_manager.mapper.horse.HorseDTOToIHorseEntityMapper;
import com.accenture.horse_auto_manager.mapper.horse.HorseEntityToHorseDTOMapper;
import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;
import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.domain.horses.RFIDChipEntity;
import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.domain.person.StablemanEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.food.FoodRepository;
import com.accenture.horse_auto_manager.repositories.food.MedicineRepository;
import com.accenture.horse_auto_manager.repositories.horses.HorseRepository;
import com.accenture.horse_auto_manager.repositories.horses.RFIDRepository;
import com.accenture.horse_auto_manager.repositories.person.DoctorRepository;
import com.accenture.horse_auto_manager.repositories.person.StablemanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorseService {

    LocalTime breakfast = LocalTime.parse("06:00:00");
    LocalTime launch = LocalTime.parse("11:00:00");
    LocalTime dinner = LocalTime.parse("17:00:00");

    @Autowired
    HorseRepository horseRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    StablemanRepository stablemanRepository;
    @Autowired
    HorseDTOToIHorseEntityMapper horseDTOMapper;
    @Autowired
    HorseEntityToHorseDTOMapper horseEntityMapper;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    RFIDRepository rfidChipRepository;

    boolean operationFeedingDone = false;

    public void feed(){
        //if horse is while can not eat oat
        //if horse is brown or black can eat oat
        // eat 2x oats, 3x hay, 1x pressed grass
        /*
        if (horse.getColor().equals("brown")
                || horse.getColor().equals("black") &&
                eatingTimeBetween(breakfast, launch))
        {
            releasedFood("oat", "hay", "grass");
        }
        releasedFood("hay", "pressed grass");

         */
    }


    public String feedingCycle(String foodtype) {
        List<FoodEntity> mealList = null; // taken from repository (DB)
        if (foodtype.equals("oat")){
            //mealList.remove(""); mealList.remove(200*MealEntity.portionInGrams());
        }
        return null;
    }

    public List<HorseDTO> getHorses() {

        List<HorseDTO> horseDTOList = new ArrayList<>();
        List<HorseEntity> horseEntityList = horseRepository.findAll();

        horseEntityList.forEach(horseEntity -> horseDTOList.add(horseEntityMapper
                .mapHorseEntityToHorseDTO(horseEntity)));

        return horseDTOList;
    }

    public HorseDTO getHorseById(Long horse_id){

        HorseEntity horseEntity = horseRepository.findById(horse_id).get();

        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);

    }

    public HorseEntity getHorseEntityById(Long horse_id){

        //HorseEntity horseEntity = horseDTOMapper.mapHorseDTOToHorseEntity(horseRepository.findById(horse_id).get());
        HorseEntity horseEntity = horseRepository.findById(horse_id).get();
        return horseEntity;

    }

    /*TODO:
        See if you can do it shorter.
     */

    // every new horse has to be assigned a chip by the user. The chip is taken out of storage.
    // available chips are 10. Ids: 1-10
    public HorseDTO createHorse(HorseDTO horseDTO) {
        HorseEntity horseEntity = horseDTOMapper.mapHorseDTOToHorseEntity(horseDTO);

        // will find chip from storage and assign it to horse according to input from user
        RFIDChipEntity rfidChipEntity = rfidChipRepository.findById(horseDTO.getChip_id()).get();
        rfidChipEntity = saveEatingTimes(horseDTO, rfidChipEntity);

        horseEntity.setRfidChip(rfidChipEntity);
        horseEntity = horseRepository.save(horseEntity);

        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);
    }


    /////////////////////////////


    ////////////////////////////

    private RFIDChipEntity saveEatingTimes(HorseDTO horseDTO,
                                RFIDChipEntity rfidChipEntity){
        if (horseDTO.getColor().equals("black")) {
            rfidChipEntity.setBreakfastTime(LocalTime.parse("07:00:00"));
            rfidChipEntity.setLaunchTime(LocalTime.parse("12:00:00"));
            rfidChipEntity.setDinnerTime(LocalTime.parse("17:00:00"));
            return rfidChipEntity;
        }
        if (horseDTO.getColor().equals("brown")) {
            rfidChipEntity.setBreakfastTime(LocalTime.parse("09:00:00"));
            rfidChipEntity.setLaunchTime(LocalTime.parse("14:00:00"));
            rfidChipEntity.setDinnerTime(LocalTime.parse("16:00:00"));
            return rfidChipEntity;
        }
        if (horseDTO.getColor().equals("white")) {
            rfidChipEntity.setBreakfastTime(LocalTime.parse("11:00:00"));
            rfidChipEntity.setLaunchTime(LocalTime.parse("16:00:00"));
            rfidChipEntity.setDinnerTime(LocalTime.parse("21:00:00"));
            return rfidChipEntity;
        }
        return rfidChipEntity;
    }
    public HorseDTO assignDoctorToHorse(Long doctor_id, Long horse_id) {
        HorseEntity horseEntity = getHorseEntityById(horse_id);
        DoctorEntity doctorEntity = doctorRepository.findById(doctor_id).get();
        horseEntity.setDoctor(doctorEntity);
        horseEntity = horseRepository.save(horseEntity);
        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);
    }

    public HorseDTO assignStablemanToHorse(Long stableman_id, Long horse_id) {
        HorseEntity horseEntity = getHorseEntityById(horse_id);
        StablemanEntity stablemanEntity = stablemanRepository.findById(stableman_id).get();
        horseEntity.setStableman(stablemanEntity);
        horseEntity = horseRepository.save(horseEntity);

        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);
    }

    public String removeHorse(Long horse_id){
        horseRepository.deleteById(horse_id);
        return "horse with ID: "+horse_id+ " has been deleted.";
    }

    public HorseDTO assignFoodToHorseService(Long food_id, Long horse_id) {
        HorseEntity horseEntity = getHorseEntityById(horse_id);
        FoodEntity foodEntity = foodRepository.findById(food_id).get();

        horseEntity.setFood(foodEntity);
        horseEntity = horseRepository.save(horseEntity);

        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);
    }

    public HorseDTO assignMedicineToHorseService(Long medicine_id, Long horse_id) {
        HorseEntity horseEntity = getHorseEntityById(horse_id);
        MedicineEntity medicineEntity = medicineRepository.findById(medicine_id).get();
        horseEntity.setMedicine(medicineEntity);
        horseEntity = horseRepository.save(horseEntity);

        return horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity);
    }

    public boolean ifChipDoNotExistInStorage(Long horse_id) {
        if(!horseRepository.existsById(horse_id))
            return true;
        return false;
    }
}
