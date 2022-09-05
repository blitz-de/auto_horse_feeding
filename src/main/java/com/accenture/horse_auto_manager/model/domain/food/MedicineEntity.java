package com.accenture.horse_auto_manager.model.domain.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //horse contrlller, feed controller, verwaltungscontroller
@Table(name = "tab_medicine")
@Getter
@Setter
public class MedicineEntity {

    @Id
    @Column(name = "medicine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineID;
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name = "expiration_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime expirationDate;
    @Column(name = "quantity")
    private Long quantity;

    @OneToMany(mappedBy = "medicine")
    private List<HorseEntity> horses;
    //private Long availableQuantity;
}
