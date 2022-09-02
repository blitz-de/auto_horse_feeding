package com.accenture.horse_auto_manager.repositories.person;

import com.accenture.horse_auto_manager.model.domain.person.StablemanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StablemanRepository extends JpaRepository<StablemanEntity, Long> {
}
