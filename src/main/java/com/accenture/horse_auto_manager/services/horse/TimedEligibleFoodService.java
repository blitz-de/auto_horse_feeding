package com.accenture.horse_auto_manager.services.horse;

import java.time.LocalTime;

public class TimedEligibleFoodService {

    //if breakfast -> only white horses eat
    // if launch -> only brown horses eat
    // LocalTime
    public boolean eatingTimeBetween(LocalTime localTime1, LocalTime localTime2){
        if (localTime1.isBefore(localTime2)) return true;
        return false;
    }

}
