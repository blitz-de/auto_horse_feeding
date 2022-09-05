package com.accenture.horse_auto_manager.services.horse;

import com.accenture.horse_auto_manager.mapper.horse.RfidChipEntityToRfidChipDTOMapper;
import com.accenture.horse_auto_manager.model.domain.horses.RFIDChipEntity;
import com.accenture.horse_auto_manager.model.dto.horses.RFIDChipDTO;
import com.accenture.horse_auto_manager.repositories.horses.RFIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RfidChipService {

    @Autowired
    RFIDRepository rfidRepository;

    @Autowired
    RfidChipEntityToRfidChipDTOMapper rfidDTOMapper;
    public List<RFIDChipDTO> getAllChipsService() {
        List<RFIDChipDTO> rfidChipDTOList = new ArrayList<>();
        List<RFIDChipEntity> rfidChipEntityList = rfidRepository.findAll();

        rfidChipEntityList.forEach(rfidChipEntity ->
                rfidChipDTOList.add(
                        rfidDTOMapper.mapRfidChipEntityToRfidChipDTO(rfidChipEntity)));
        return rfidChipDTOList;
    }

    public RFIDChipDTO getChipByIDService(Long chip_id) {
        RFIDChipEntity rfidChipEntity = rfidRepository.findById(chip_id).get();

        return rfidDTOMapper.mapRfidChipEntityToRfidChipDTO(rfidChipEntity);
    }

    public boolean ifChipIDDoNotExist(Long chip_id) {
        if(!rfidRepository.existsById(chip_id))
            return true;
        return false;
    }
}
