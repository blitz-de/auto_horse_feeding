package com.accenture.horse_auto_manager.repositories.food;

import com.accenture.horse_auto_manager.model.domain.food.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
