package com.accenture.horse_auto_manager.model.domain.person;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tab_stableman")
@Getter
@Setter
public class StablemanEntity extends PersonEntity{

    /*@Id
    @Column(name = "stableman_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stablemanID;
     */
    @OneToMany(mappedBy = "stableman")
    private List<HorseEntity> horses;

}
