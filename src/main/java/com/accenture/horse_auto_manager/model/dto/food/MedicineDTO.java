package com.accenture.horse_auto_manager.model.dto.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class MedicineDTO {

    private Long medicineID;
    private String medicineName;
    private String expirationDate;
    private Long quantity;

    private HorseEntity horse;
}
