package org.bu01.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "organization")

public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organization_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_id")
    public Organization parentId;
    @JsonManagedReference
    @OneToMany(mappedBy = "parentId")
    private Set<Organization> children = new HashSet<Organization>();

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "effective_start_date")
    private Date effectiveStartDate;

    @Column(name = "effective_end_date")
    private Date effectiveEndDate;


    @OneToOne(mappedBy = "organization_id")
    private RecruitmentOrganization recruitmentOrganization;

    public Organization() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getParentId() {
        return parentId;
    }

    public void setParentId(Organization parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(Date effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    public Set<Organization> getChildren() {
        return children;
    }

    public void setChildren(Set<Organization> children) {
        this.children = children;
    }

    public RecruitmentOrganization getRecruitmentOrganization() {
        return recruitmentOrganization;
    }

    public void setRecruitmentOrganization(RecruitmentOrganization recruitmentOrganization) {
        this.recruitmentOrganization = recruitmentOrganization;
    }
}
