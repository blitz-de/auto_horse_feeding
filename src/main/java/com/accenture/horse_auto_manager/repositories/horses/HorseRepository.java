package com.accenture.horse_auto_manager.repositories.horses;

import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorseRepository extends JpaRepository<HorseEntity, Long> {
}
