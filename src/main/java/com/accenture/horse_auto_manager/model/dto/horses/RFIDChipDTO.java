package com.accenture.horse_auto_manager.model.dto.horses;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RFIDChipDTO {

    private Long chip_id;
    private LocalTime timeOfReleasedFood; //feeding cycle = length.timeOfReleasedFood per day
    private String feedingStation;
    private boolean ifFoodIsReleased;
    private boolean hadBreakfast;
    private boolean hadLaunch;
    private boolean hadDinner;

    private boolean operationDone;
    private LocalTime breakfastTime;
    private LocalTime launchTime;
    private LocalTime dinnerTime;

    private HorseDTO horse;

}
