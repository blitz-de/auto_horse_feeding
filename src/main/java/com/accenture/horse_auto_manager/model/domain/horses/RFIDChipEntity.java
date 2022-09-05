package com.accenture.horse_auto_manager.model.domain.horses;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tab_rfid_chip")
@Data
public class RFIDChipEntity { // horse has a GUID-CHIP
    @Id
    @Column(name = "chip_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chip_id;
    @Column(name = "time_of_released_food")
    private LocalTime timeOfReleasedFood; //feeding cycle = length.timeOfReleasedFood per day
    @Column(name = "feeding_station")
    private String feedingStation;
    @Column(name = "food_released")
    private boolean ifFoodIsReleased;

    /*new */
    @Column(name = "operation_done")
    private boolean operationDone;
    //private int eatingTimes = 3;
    @Column(name = "had_breakfast")
    private boolean hadBreakfast = false;
    @Column(name = "had_launch")
    private boolean hadLaunch = false;
    @Column(name = "had_dinner")
    private boolean hadDinner = false;

    //TODO: check again if it was a good idea. and add to DTO
    @Column(name = "breakfast_time")
    private LocalTime breakfastTime; // 07:00. 09:00, 11:00
    @Column(name = "launch_time")
    private LocalTime launchTime; // 12:00, 14:00, 16:00
    @Column(name = "dinner_time")
    private LocalTime dinnerTime; // 17:00, 19:00, 21:00

    @OneToOne(mappedBy = "rfidChip")
    private HorseEntity horse;

}
