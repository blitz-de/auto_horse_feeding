package com.accenture.horse_auto_manager.services.person;

import com.accenture.horse_auto_manager.mapper.horse.HorseEntityToHorseDTOMapper;
import com.accenture.horse_auto_manager.mapper.person.StablemanDTOToStablemanEntityMapper;
import com.accenture.horse_auto_manager.mapper.person.StablemanEntityToStablemanDTOMapper;
import com.accenture.horse_auto_manager.model.domain.horses.HorseEntity;
import com.accenture.horse_auto_manager.model.domain.person.StablemanEntity;
import com.accenture.horse_auto_manager.model.dto.person.StablemanDTO;
import com.accenture.horse_auto_manager.repositories.person.StablemanRepository;
import com.accenture.horse_auto_manager.services.horse.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StablemanService {

    @Autowired
    StablemanDTOToStablemanEntityMapper stablemanDTOMapper;
    @Autowired
    StablemanEntityToStablemanDTOMapper stablemanEntityMapper;
    @Autowired
    StablemanRepository stablemanRepository;

    @Autowired
    HorseEntityToHorseDTOMapper horseEntityMapper;
    @Autowired
    HorseService horseService;

    public StablemanDTO createStableman(StablemanDTO stablemanDTO){
        StablemanEntity stablemanEntity = stablemanDTOMapper.mapStablemanDTOToStablemanEntity(stablemanDTO);
        stablemanEntity = stablemanRepository.save(stablemanEntity);
        return stablemanEntityMapper.mapStablemanToStablemanDTO(stablemanEntity);
    }

    public StablemanDTO getStablemanById(Long stableman_id){

        StablemanEntity stablemanEntity = stablemanRepository.findById(stableman_id).get();

        return stablemanEntityMapper.mapStablemanToStablemanDTO(stablemanEntity);

    }

    public List<StablemanDTO> getAllStablemen(){
        List<StablemanDTO> stablemanDTOList = new ArrayList<>();
        List<StablemanEntity> stablemanEntityList = stablemanRepository.findAll();

        stablemanEntityList.forEach(stablemanEntity ->
                stablemanDTOList.add(stablemanEntityMapper.mapStablemanToStablemanDTO(stablemanEntity)));

        return stablemanDTOList;
    }

}
