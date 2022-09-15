package com.workapi.workapi.service;

import com.workapi.workapi.model.Mission;
import com.workapi.workapi.repository.MissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MissionService {
    private MissionRepository missionRepository;

    @Transactional
    public List<Mission> addMissions(List<Mission> missions){
        return missionRepository.saveAll(missions);
    }

    @Transactional
    public Mission updateMission(Mission mission){
        return missionRepository.save(mission);
    }

}
