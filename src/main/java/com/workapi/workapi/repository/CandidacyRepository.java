package com.workapi.workapi.repository;


import com.workapi.workapi.model.Candidacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidacyRepository extends JpaRepository<Candidacy, Long> {
    List<Candidacy> findCandidaciesByOffer_id(Long offer_id);

    List<Candidacy> findCandidaciesByUser_id(Long user_id);
}
