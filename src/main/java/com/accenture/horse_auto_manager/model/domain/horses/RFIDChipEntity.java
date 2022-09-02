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

    @OneToOne(mappedBy = "rfidChip")
    private HorseEntity horse;

}
