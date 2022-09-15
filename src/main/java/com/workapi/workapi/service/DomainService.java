package com.workapi.workapi.service;

import com.workapi.workapi.model.Domain;
import com.workapi.workapi.repository.DomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DomainService {
    private DomainRepository domainRepository;

    public List<Domain> getAll(){
        return domainRepository.findAll();
    }

    @Transactional
    public List<Domain> createDomain(List<Domain> domains){
        return domainRepository.saveAll(domains);
    }

    @Transactional
    public Domain updateDomain(Domain domain){
        return domainRepository.save(domain);
    }

    public Domain getById(Long id) {
        return domainRepository.findById(id).get();
    }
}
