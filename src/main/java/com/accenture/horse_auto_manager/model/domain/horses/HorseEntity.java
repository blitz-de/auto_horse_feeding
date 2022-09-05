package com.accenture.horse_auto_manager.model.domain.horses;

import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;
import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import com.accenture.horse_auto_manager.model.domain.person.StablemanEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
// Hibernate oder flyway -- Futterzeit
@Entity
@Table(name = "tab_horses")
@Getter
@Setter
//@ToString
public class HorseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guid", nullable = false)
    private Long guid; // necessary for the rfid
    private String name; // needed for doctors
    private String nickname;
    private String color;
    @Column(name = "breed_name")
    private String breedName;
    private String type; // horse or pony
    //private HashMap<HorseEntity, String> food_preferences;


    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id") // doctorID
    private DoctorEntity doctor;
    @ManyToOne
    @JoinColumn(name = "stableman_id")
    private StablemanEntity stableman; // owner
    @OneToOne
    @JoinColumn(name = "chip_id")
    private RFIDChipEntity rfidChip;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodEntity food;
    /*@ManyToMany
    @JoinTable(
            name = "preferred_food_by_horse",
            joinColumns = @JoinColumn(name = "horse_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    //@JoinColumn(name = "food_id")
    private List<FoodEntity> preferred_foods;
     */
    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private MedicineEntity medicine;
    // typ-rasse-
}
