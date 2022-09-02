package com.accenture.horse_auto_manager.repositories.horses;

import com.accenture.horse_auto_manager.model.domain.horses.RFIDChipEntity;
import com.accenture.horse_auto_manager.model.dto.horses.RFIDChipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFIDRepository extends JpaRepository<RFIDChipEntity, Long> {
}
