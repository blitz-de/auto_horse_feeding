package com.accenture.horse_auto_manager.model.dto.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.dto.horses.HorseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class FoodDTO {

    private Long foodID;
    private String foodName;
    private String expirationDate;
    private Long portionInGrams; // one portion is 100 g
    private Long foodLeft;

    //private HorseEntity horse;

    private List<HorseDTO> horses;
}
