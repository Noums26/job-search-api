package com.workapi.workapi.controller;

import com.workapi.workapi.model.Candidacy;
import com.workapi.workapi.model.Mission;
import com.workapi.workapi.model.Offers;
import com.workapi.workapi.model.Users;
import com.workapi.workapi.service.CandidacyService;
import com.workapi.workapi.service.MissionService;
import com.workapi.workapi.service.OffersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/offers")
public class OffersController {
    private OffersService offersService;
    private MissionService missionService;
    private CandidacyService candidacyService;

    @GetMapping("")
    public List<Offers> getAll() {
        return offersService.getAll();
    }

    @GetMapping("/{id}")
    public Offers getById(@PathVariable Long id) {
        return offersService.getById(id);
    }

    @PutMapping("")
    public Offers updateOffers(@RequestBody Offers offer) {
        return offersService.updateOffer(offer);
    }

    @PostMapping("")
    public Offers createOffer(@RequestBody Offers offer) {
        return offersService.createOffer(offer);
    }

    @PostMapping("/missions")
    public List<Mission> addMission(@RequestBody List<Mission> missions) {
        return missionService.addMissions(missions);
    }

    @GetMapping("/{offer_id}/candidates")
    public List<Users> getAllCandidates(@PathVariable Long offer_id) {
        return candidacyService.getCandidatesForAnOffer(offer_id);
    }

    @PostMapping("/{offer_id}/postulate")
    public Candidacy postulate(@RequestBody Candidacy post){
        return candidacyService.postulate(post);
    }
}
