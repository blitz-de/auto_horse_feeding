package com.accenture.horse_auto_manager.services.horse;

import com.accenture.horse_auto_manager.model.domain.horses.RFIDChipEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.horses.RFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ReleaseFoodService {

    LocalTime breakfast = LocalTime.parse("06:00:00");
    LocalTime launch = LocalTime.parse("12:00:00");
    LocalTime dinner = LocalTime.parse("17:00:00");
    LocalTime sleepTime = LocalTime.parse("21:00:00");

    @Autowired RFIDRepository rfidRepository;
    /*public List<String> releasedFood(String... foodtype) {
        return Arrays.asList(foodtype);
    }*/

    public boolean openForBreakfast(Long chip_id, HorseDTO horseDTO) {
        RFIDChipEntity rfidChipEntity = rfidRepository.findById(chip_id).get();

        if (rfidChipEntity.isHadBreakfast() == false
                && releaseFoodOnOpeningHours(rfidChipEntity)){
            //foodPreferenceService.feed(horseDTO.getGuid());
            rfidChipEntity.setOperationDone(true);
            rfidChipEntity.setHadBreakfast(true);
            rfidRepository.save(rfidChipEntity);
            closeFoodContainer(rfidChipEntity);
            return rfidChipEntity.isHadBreakfast(); //true

        } else {
            rfidChipEntity.setOperationDone(false);
            return false;
        }
    }
    public boolean openForLaunch(Long chip_id, HorseDTO horseDTO) {
        RFIDChipEntity rfidChipEntity = rfidRepository.findById(chip_id).get();

        if (rfidChipEntity.isHadLaunch() == false
                && releaseFoodOnOpeningHours(rfidChipEntity)){
           // foodPreferenceService.feed(horseDTO.getGuid());
            rfidChipEntity.setOperationDone(true);
            rfidChipEntity.setHadLaunch(true);
            rfidRepository.save(rfidChipEntity);
            closeFoodContainer(rfidChipEntity);
            return rfidChipEntity.isHadLaunch(); //true

        } else {
            rfidChipEntity.setOperationDone(false);
            return false;
        }
    }
    public boolean openForDinner(Long chip_id, HorseDTO horseDTO) {
        RFIDChipEntity rfidChipEntity = rfidRepository.findById(chip_id).get();
        if (rfidChipEntity.isHadDinner() == false
                && releaseFoodOnOpeningHours(rfidChipEntity)){
            //foodPreferenceService.feed(horseDTO.getGuid());
            rfidChipEntity.setOperationDone(true);
            rfidChipEntity.setHadDinner(true);
            rfidRepository.save(rfidChipEntity);
            closeFoodContainer(rfidChipEntity);
            return rfidChipEntity.isHadDinner(); //true

        } else {
            rfidChipEntity.setOperationDone(false);
            return false; //false
        }
        //false
    }
    /*TODO*/
    public void walkToFoodStation(Long chip_id, HorseDTO horseDTO){
        RFIDChipEntity rfidChipEntity = rfidRepository.findById(chip_id).get();

        if (!rfidChipEntity.isHadBreakfast() //==true
            && !rfidChipEntity.isHadLaunch()
            && !rfidChipEntity.isHadDinner()) {

            rfidChipEntity.setHadBreakfast(true);
            rfidChipEntity.setHadLaunch(true);
            rfidChipEntity.setHadDinner(true);
            rfidRepository.save(rfidChipEntity);
        }
        if (LocalTime.now().isBefore(launch)) {
            openForBreakfast(chip_id, horseDTO);
        }
        if (LocalTime.now().isBefore(dinner))
            openForLaunch(chip_id, horseDTO);
        if (LocalTime.now().isBefore(sleepTime)) {
            openForDinner(chip_id, horseDTO);
        }
    }

    private void closeFoodContainer(RFIDChipEntity rfidChipEntity) {
        rfidChipEntity.setOperationDone(false);
        rfidRepository.save(rfidChipEntity);
    }

    /**
     * visiting-table -- id -- date -- request_breakfast --request_launch -- request_dinner
     * openForBreakfast(), openForLaunch(), openForDinner()
     * After the scan -- findHorseById()
     * -- Entry -- breakfast(false), launch(false), dinner(false)
     * breakfastBedingungen - false -- launchBedinungen - update to true
     *
     */


    public boolean releaseFoodOnOpeningHours(RFIDChipEntity rfidChipEntity){
        if (LocalTime.now().isAfter(sleepTime)
            && LocalTime.now().isBefore(breakfast)) return false;
       // startNewDay(rfidChipEntity);
        return true;
    }

    /*
    public boolean startNewDay(RFIDChipEntity rfidChipEntity) {
        if(LocalTime.now().isAfter(breakfast)
        && LocalDateTime.now().isAfter(rfidChipEntity.getTimeOfReleasedFood())
        && rfidChipEntity.getEatingTimes()==0){
            //rfidChipEntity.setOperationDone(false);
            rfidChipEntity.setEatingTimes(3);
            rfidRepository.save(rfidChipEntity);
            return true;
        }
        return false;
    }
     */
}