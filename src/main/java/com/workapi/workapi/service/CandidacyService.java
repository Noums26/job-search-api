package com.workapi.workapi.service;

import com.workapi.workapi.model.Candidacy;
import com.workapi.workapi.model.Offers;
import com.workapi.workapi.model.Users;
import com.workapi.workapi.repository.CandidacyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CandidacyService {
    private CandidacyRepository candidacyRepository;

    public List<Users> getCandidatesForAnOffer(Long offer_id){
        List<Candidacy> candidacies = candidacyRepository.findCandidaciesByOffer_id(offer_id);

        List<Users> candidates = new ArrayList<>();

        candidacies.forEach(candidacy -> {candidates.add(candidacy.getUser());});
        return candidates;
    }

    public List<Offers> getOffersForACandidate(Long user_id){
        List<Candidacy> candidacies = candidacyRepository.findCandidaciesByUser_id(user_id);

        List<Offers> offers = new ArrayList<>();

        candidacies.forEach(candidacy -> {offers.add(candidacy.getOffer());});

        return offers;
    }

    @Transactional
    public Candidacy postulate(Candidacy post){
        return candidacyRepository.save(post);
    }
}
