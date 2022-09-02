package com.accenture.horse_auto_manager.repositories.person;

import com.accenture.horse_auto_manager.model.domain.person.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {


    //Optional<DoctorEntity> findById(Long doctor_id);
}
