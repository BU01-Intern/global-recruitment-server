package org.bu01.database.controllers;

import org.bu01.database.dto.OrganizationDto;
import org.bu01.database.entities.Organization;
import org.bu01.database.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationRepository repository;

    @PostMapping("/create")
    ResponseEntity<?> createrOrganization(@RequestBody OrganizationDto organization){
        System.out.println(organization.getParentId());
        if(repository.existsAllByName(organization.getName())){
            return new ResponseEntity<>("Name is existed!", HttpStatus.BAD_REQUEST);
        }
        if(repository.existsByCode(organization.getCode())){
            return new ResponseEntity<>("Code is existed!", HttpStatus.BAD_REQUEST);
        }

        Organization newOrg = new Organization();
        newOrg.setCode(organization.getCode());
        newOrg.setName(organization.getName());
        newOrg.setEffectiveEndDate(organization.getEffectiveEndDate());
        newOrg.setEffectiveStartDate(organization.getEffectiveStartDate());
        if(repository.existsAllById(organization.getParentId())){
            newOrg.setParentId(repository.findAllById(organization.getParentId()));
        }
        repository.save(newOrg);
        return new ResponseEntity<>("Create successfully!", HttpStatus.OK);
    }

    @GetMapping("/get-all")
    List<Organization> getOrganization(){
        return repository.findAll();
    }


}
