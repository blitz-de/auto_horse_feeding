package com.accenture.horse_auto_manager.services.food;

import com.accenture.horse_auto_manager.mapper.horse.HorseEntityToHorseDTOMapper;
import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.accenture.horse_auto_manager.repositories.horses.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimedEligibleFoodService {

    @Autowired
    HorseRepository horseRepository;
    @Autowired
    HorseEntityToHorseDTOMapper horseEntityMapper;

    // TODO: correct mistake. Return value doesnt return the time in-beween
    public boolean eatingTimeBetween(LocalTime localTime1, LocalTime localTime2){
        if (localTime1.isBefore(localTime2)) return true;
        return false;
    }

    public List<HorseDTO> getHorsesByLocalTime(LocalTime time) {
        List<HorseDTO> horseDTOList = new ArrayList<>();
        List<HorseEntity> horseEntityList = getAccordingTime(time);

        horseEntityList.forEach(horseEntity->
                horseDTOList.add(horseEntityMapper.mapHorseEntityToHorseDTO(horseEntity)));

        return horseDTOList;
    }

    public List<HorseEntity> getAccordingTime(LocalTime time) {
        // breakfast - black
        if (time.isAfter(LocalTime.parse("06:59:59")) &&
                time.isBefore(LocalTime.parse("09:00:00"))
                //launch
                || (time.isAfter(LocalTime.parse("11:59:59")) &&
                time.isBefore(LocalTime.parse("13:55:59")))
                //dinner
                || ((time.isAfter(LocalTime.parse("17:00:00")) &&
                time.isBefore(LocalTime.parse("18:55:59"))))
        ) {
            return horseRepository.findBlackByLocalTime(time);
        }

        if (time.isAfter(LocalTime.parse("08:59:59")) &&
                time.isBefore(LocalTime.parse("11:00:00"))
                //launch
                || (time.isAfter(LocalTime.parse("13:59:59")) &&
                time.isBefore(LocalTime.parse("15:55:59")))
                //dinner
                || ((time.isAfter(LocalTime.parse("18:59:59")) &&
                time.isBefore(LocalTime.parse("20:55:59"))))
        ) {
            return horseRepository.findBrownByLocalTime(time);
        }

        if (time.isAfter(LocalTime.parse("10:59:59")) &&
                time.isBefore(LocalTime.parse("13:59:59"))
                //launch
                || (time.isAfter(LocalTime.parse("15:59:59")) &&
                time.isBefore(LocalTime.parse("20:55:59")))
                //dinner
                || ((time.isAfter(LocalTime.parse("20:59:59")) &&
                time.isBefore(LocalTime.parse("22:00:00"))))
        ) {
            return horseRepository.findWhiteByLocalTime(time);
        }


        /*if (time.isAfter(LocalTime.parse("06:59:59")) &&
                (time.isAfter(LocalTime.parse("13:59:59")))&&
                (time.isBefore(LocalTime.parse("16:59:59")))) {
            return horseRepository.findBlackByLocalTime(time);
        }

        // breakfast - brown
        if (time.isAfter(LocalTime.parse("08:59:59")) &&
                (time.isAfter(LocalTime.parse("13:59:59")))&&
                (time.isBefore(LocalTime.parse("16:59:59")))) {
            return horseRepository.findBrownByLocalTime(time);
        }
        // breakfast - white
        if (time.isAfter(LocalTime.parse("08:59:59")) &&
                (time.isAfter(LocalTime.parse("13:59:59")))&&
                (time.isAfter(LocalTime.parse("20:59:59")))) {
            return horseRepository.findWhiteByLocalTime(time);
        }

         */
        return null;
    }

    /*
    public List<HorseDTO> eligibleTimes(HorseDTO horseDTO,
                                        List<HorseEntity> horseEntityList,
                                        LocalTime eatingAfter, LocalTime eathingBefore){
        List<HorseDTO> horseDTOList = new ArrayList<>();
        // get whitehorses, blackhorses, brownhorses accordingly

        if (horseDTO.getEligibleEatingTimes().isAfter(eatingAfter)
                && horseDTO.getEligibleEatingTimes().isBefore(eathingBefore)){

            horseEntityList.forEach(horseEntity -> horseDTOList.add(
                    horseDTOMapper.mapHorseEntityToHorseDTO(horseEntity)));
            return horseDTOList;
        }
        return horseDTOList;
    }*/

    /*
    public List<HorseDTO> getHorseAtEligibleEatingTimeService(HorseDTO horseDTO) {

        if (horseDTO.getColor().equals("white")) {
          //  List<HorseEntity> horseEntityList = horseRepository.findAllByWhiteColor();
            //return eligibleTimes(horseDTO, horseEntityList, breakfastTimeWhiteHorses1,
              //      breakfastTimeWhiteHorses2);
        }
        return null;
    }
     */

}
