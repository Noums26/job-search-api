package com.workapi.workapi.repository;

import com.workapi.workapi.model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffersRepository extends JpaRepository<Offers, Long> {
    List<Offers> findAllByStateEquals(boolean state);
}
