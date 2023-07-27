package org.bu01.database.controllers;

import org.bu01.database.dto.OrganizationDto;
import org.bu01.database.dto.RecruitmentOrganizationDto;
import org.bu01.database.entities.Organization;
import org.bu01.database.entities.RecruitmentOrganization;
import org.bu01.database.repositories.OrganizationRepository;
import org.bu01.database.repositories.RecruitmentOrganizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/org")
public class OrganizationController {
    @Autowired
    private OrganizationRepository repository;
    @Autowired
    private RecruitmentOrganizationRepository recruitmentOrganizationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    ResponseEntity<?> createOrganization(@RequestBody OrganizationDto organization){
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
        if(organization.getParentId() != null) {
            UUID parentId = UUID.fromString(organization.getParentId());
            if (repository.existsById(parentId)) {
                newOrg.setParentId(repository.getReferenceById(parentId));
            } else {
                newOrg.setParentId(null);
            }
        } else {
            newOrg.setParentId(null);
        }
        repository.save(newOrg);
        return new ResponseEntity<>("Create successfully!", HttpStatus.OK);
    }

    @GetMapping("/get-treeOrg/{name}")
    public ResponseEntity<?> getTreeOrg(@PathVariable String name) {
        if(repository.existsByNameIgnoreCase(name)) {
            Organization parentOrg = repository.getByNameIgnoreCase(name);
            return new ResponseEntity<>(parentOrg, HttpStatus.OK);
        }
        return new ResponseEntity<>("Does not exist", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get-all")
    List<Organization> getOrganization(){
        return repository.findAll();
    }

    @GetMapping("/recruitment/get-brief")
    List<RecruitmentOrganizationDto.ResponseRecruitment> getRecruitment(){
        List<RecruitmentOrganization> listRecruitment = recruitmentOrganizationRepository.findAll();
        List<RecruitmentOrganizationDto.ResponseRecruitment> rct = new ArrayList<>();
        for(int i = 0; i < listRecruitment.size(); i++){
            rct.add(modelMapper.map(listRecruitment.get(i),RecruitmentOrganizationDto.ResponseRecruitment.class));
        }
        return rct;
    }

    @PostMapping("/recruitment/create-recruitment-org")
    ResponseEntity<?> createRecruitmentOrg(@RequestBody RecruitmentOrganizationDto.RequestRecruitmentOrganization recruitmentOrganization){
        if(repository.existsByCode(recruitmentOrganization.getOrganizationCode())){
            RecruitmentOrganization newRecruitmentOrg = new RecruitmentOrganization();
            newRecruitmentOrg.setOrganization_id(repository.findOrganizationByCode(recruitmentOrganization.getOrganizationCode()));
            newRecruitmentOrg.setScope(recruitmentOrganization.getScope());
            newRecruitmentOrg.setRecruitmentClues(recruitmentOrganization.getRecruitmentClues());
            newRecruitmentOrg.setRecruitmentCluesPhone(recruitmentOrganization.getRecruitmentCluesPhone());
            newRecruitmentOrg.setRecruitmentCluesEmail(recruitmentOrganization.getRecruitmentCluesEmail());
            newRecruitmentOrg.setEffectiveStartDate(recruitmentOrganization.getEffectiveStartDate());
            newRecruitmentOrg.setEffectiveEndDate(recruitmentOrganization.getEffectiveEndDate());
            newRecruitmentOrg.setInformation(recruitmentOrganization.getInformation());
            newRecruitmentOrg.setIsActive(recruitmentOrganization.getIsActive());
            newRecruitmentOrg.setOfficeAddress(recruitmentOrganization.getOfficeAddress());
            newRecruitmentOrg.setIsPrivate(recruitmentOrganization.getIsPrivate());
            recruitmentOrganizationRepository.save(newRecruitmentOrg);
            return new ResponseEntity<>("Created!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/recruitment/update/{id}")
    ResponseEntity<?> updateRecruitmentOrg(@PathVariable UUID id, @RequestBody RecruitmentOrganizationDto.RequestRecruitmentOrganization request){
        if(recruitmentOrganizationRepository.existsById(id)){
            RecruitmentOrganization existedRecruitmentOrg = recruitmentOrganizationRepository.findAllById(id);
            if(repository.existsByCode(request.getOrganizationCode())){
                existedRecruitmentOrg.setOrganization_id(repository.findOrganizationByCode(request.getOrganizationCode()));
                existedRecruitmentOrg.setEffectiveStartDate(request.getEffectiveStartDate());
                existedRecruitmentOrg.setEffectiveStartDate(request.getEffectiveStartDate());
                existedRecruitmentOrg.setRecruitmentCluesEmail(request.getRecruitmentCluesEmail());
                existedRecruitmentOrg.setRecruitmentClues(request.getRecruitmentClues());
                existedRecruitmentOrg.setRecruitmentCluesPhone(request.getRecruitmentCluesPhone());
                existedRecruitmentOrg.setIsPrivate(request.getIsPrivate());
                existedRecruitmentOrg.setIsActive(request.getIsActive());
                existedRecruitmentOrg.setScope(request.getScope());
                existedRecruitmentOrg.setInformation(request.getInformation());
                existedRecruitmentOrg.setOfficeAddress(request.getOfficeAddress());
                recruitmentOrganizationRepository.save(existedRecruitmentOrg);
                return new ResponseEntity<>("Updated!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Not Found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/recruitment/remove/{id}")
    ResponseEntity<?> removeRecruitmentOrg(@PathVariable UUID id){
        if(recruitmentOrganizationRepository.existsById(id)){
            recruitmentOrganizationRepository.deleteById(id);
            return new ResponseEntity<>("Removed!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found!", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/recruitment/get-all")
    List<RecruitmentOrganization> getAllRecruitment(){
        return recruitmentOrganizationRepository.findAll();
    }
}
