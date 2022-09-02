package com.accenture.horse_auto_manager.model.domain.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //horse contrlller, feed controller, verwaltungscontroller
@Table(name = "tab_medicine")
@Data
public class MedicineEntity {

    @Id
    @Column(name = "medicine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineID;
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name = "expiration_date")
    private String expirationDate;
    @Column(name = "quantity")
    private Long quantity;

    @OneToMany(mappedBy = "medicine",
    cascade = CascadeType.ALL,
    orphanRemoval = true
            )
    private Set<HorseEntity> horse = new HashSet<>();
    //private Long availableQuantity;
}
