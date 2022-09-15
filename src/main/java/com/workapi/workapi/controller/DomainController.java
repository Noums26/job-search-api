package com.workapi.workapi.controller;

import com.workapi.workapi.model.Domain;
import com.workapi.workapi.service.DomainService;
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
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/domains")
public class DomainController {
    private DomainService domainService;

    @GetMapping("")
    public List<Domain> getAllDomains(){
        return domainService.getAll();
    }

    @GetMapping("/{id}")
    public Domain getById(@PathVariable Long id){
        return domainService.getById(id);
    }

    @PostMapping("")
    public List<Domain> createDomain(@RequestBody List<Domain> domains){
        return domainService.createDomain(domains);
    }

    @PutMapping("")
    public Domain updateDomain(@RequestBody Domain domain){
        return domainService.updateDomain(domain);
    }
}
