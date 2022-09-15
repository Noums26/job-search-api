package com.workapi.workapi.controller;

import com.workapi.workapi.model.Mission;
import com.workapi.workapi.service.MissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    MissionService missionService;

    @PutMapping("")
    public Mission updateMission(@RequestBody Mission mission){
        return missionService.updateMission(mission);
    }
}
