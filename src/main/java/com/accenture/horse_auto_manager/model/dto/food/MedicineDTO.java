package com.accenture.horse_auto_manager.model.dto.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineDTO {

    private Long medicineID;
    private String medicineName;
    private String expirationDate;
    private Long quantity;

    private HorseEntity horse;
}
