package com.accenture.horse_auto_manager.repositories.food;

import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
}
