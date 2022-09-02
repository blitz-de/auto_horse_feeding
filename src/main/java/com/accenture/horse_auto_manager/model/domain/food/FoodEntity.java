package com.accenture.horse_auto_manager.model.domain.food;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity //horse contrlller, feed controller, verwaltungscontroller
@Table(name = "tab_food")
@Getter
@Setter
public class FoodEntity {

    @Id
    @Column(name = "food_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodID;
    @Column(name = "food_name")
    private String foodName;
    @Column(name = "expiration_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime expirationDate;
    @Column(name = "grams_per_portion")
    private final Long portionInGrams = 100L; // one portion is 100 g
    @Column(name = "food_left")
    private Long foodLeft= 1000L;
   // @Column(name = "preference")
    //private String preferredBy; // horses which prefer these types of food.

    // ManyToMany ..??
    //@ManyToMany(mappedBy="preferred_foods")
    @OneToMany(mappedBy = "food")
    private List<HorseEntity> horses;
}
