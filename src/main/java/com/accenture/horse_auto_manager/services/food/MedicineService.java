package com.accenture.horse_auto_manager.services.food;

import com.accenture.horse_auto_manager.mapper.food.MedicineDTOToMedicineEntityMapper;
import com.accenture.horse_auto_manager.mapper.food.MedicineEntityToMedicineDTOMapper;
import com.accenture.horse_auto_manager.model.domain.food.MedicineEntity;

import com.accenture.horse_auto_manager.model.dto.food.MedicineDTO;

import com.accenture.horse_auto_manager.repositories.food.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;
    @Autowired
    MedicineEntityToMedicineDTOMapper medicineEntityMapper;
    @Autowired
    MedicineDTOToMedicineEntityMapper medicineDTOMapper;


    public List<MedicineDTO> getAllMedicineService(){
        List<MedicineDTO> medicineDTOList = new ArrayList<>();
        List<MedicineEntity> medicineEntityList = medicineRepository.findAll();

        medicineEntityList.forEach(medicineEntity -> medicineDTOList.add(
                medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity)));

        return medicineDTOList;
    }

    public MedicineDTO getMedicineByIdService(Long medicine_id){
        MedicineEntity medicineEntity = medicineRepository.findById(medicine_id).get();

        return medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity);
    }

    public MedicineDTO createMedicine(MedicineDTO medicineDTO) {

        MedicineEntity medicineEntity = medicineDTOMapper.mapMedicineDTOToMedicineEntityMapper(medicineDTO);
        medicineEntity = medicineRepository.save(medicineEntity);
        return medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity);
    }

    public MedicineDTO addMedicineToStorageById(Long medicine_id, Long addmedicine) {
        MedicineEntity medicineEntity = medicineRepository.findById(medicine_id).get();
        MedicineDTO medicineDTO;
        Long addedmedicine;
        if (medicineEntity.getQuantity() == null){
            medicineEntity.setQuantity(0L);
        }
        if(medicineEntity.getMedicineName().equals("oat")) {
            addedmedicine = medicineEntity.getQuantity() +addmedicine;
            medicineEntity.setQuantity(addedmedicine);
            medicineRepository.save(medicineEntity);
            medicineDTO = medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity);
            return medicineDTO;
        }
        if(medicineEntity.getMedicineName().equals("hay")) {
            addedmedicine = medicineEntity.getQuantity() +addmedicine;
            medicineEntity.setQuantity(addedmedicine);
            medicineRepository.save(medicineEntity);
            medicineDTO = medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity);
            return medicineDTO;
        }
        if(medicineEntity.getMedicineName().equals("Pressed-Grass")) {
            addedmedicine = medicineEntity.getQuantity() +addmedicine;
            medicineEntity.setQuantity(addedmedicine);
            medicineRepository.save(medicineEntity);
            medicineDTO = medicineEntityMapper.mapMedicineEntityToMedicineDTOMapper(medicineEntity);
            return medicineDTO;
        }
        return null;
    }
}
