package com.workapi.workapi.service;

import com.workapi.workapi.model.Offers;
import com.workapi.workapi.repository.OffersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class OffersService {
    OffersRepository offersRepository;

    public List<Offers> getAll(){
        return offersRepository.findAllByStateEquals(true);
    }

    public Offers getById(Long id){
        return offersRepository.findById(id).get();
    }

    @Transactional
    public Offers updateOffer(Offers offer){
        return offersRepository.save(offer);
    }

    @Transactional
    public Offers createOffer(Offers offer){
        return offersRepository.save(offer);
    }

}
