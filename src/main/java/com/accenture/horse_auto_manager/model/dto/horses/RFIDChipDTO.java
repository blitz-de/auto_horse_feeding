package com.accenture.horse_auto_manager.model.dto.horses;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class RFIDChipDTO {

    private Long chip_id;
    private LocalDateTime timeOfReleasedFood; //feeding cycle = length.timeOfReleasedFood per day
    private String feedingStation;
    private boolean ifFoodIsReleased;
    private boolean hadBreakfast;
    private boolean hadLaunch;
    private boolean hadDinner;

    private HorseDTO horse;

}
