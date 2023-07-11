package org.bu01.database.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "recruitment_organization")
public class RecruitmentOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recruitment_organization_id")
    private UUID id;

    @Column(name = "effective_start_date")
    private Date effectiveStartDate;

    @Column(name = "effective_end_date")
    private Date effectiveEndDate;

    @Column(name = "is_active",nullable = false)
    private int isActive = 0;

    @Column(name = "is_private",nullable = false)
    private int isPrivate = 0;

    @Column(name = "scope", nullable = false)
    private int scope;

    @Column(name = "office_address", nullable = false)
    private String officeAddress;

    @Column(name = "recruitment_clues_full_name", nullable = false)
    private String recruitmentCluesFullName;

    @Column(name = "recruitment_clues", nullable = false)
    private String recruitmentClues;

    @Column(name = "recruitment_clues_phone", nullable = false)
    private String recruitmentCluesPhone;

    @Column(name = "information", columnDefinition = "text")
    private String information;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization_id;

    public RecruitmentOrganization() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(int isPrivate) {
        this.isPrivate = isPrivate;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getRecruitmentCluesFullName() {
        return recruitmentCluesFullName;
    }

    public void setRecruitmentCluesFullName(String recruitmentCluesFullName) {
        this.recruitmentCluesFullName = recruitmentCluesFullName;
    }

    public String getRecruitmentClues() {
        return recruitmentClues;
    }

    public void setRecruitmentClues(String recruitmentClues) {
        this.recruitmentClues = recruitmentClues;
    }

    public String getRecruitmentCluesPhone() {
        return recruitmentCluesPhone;
    }

    public void setRecruitmentCluesPhone(String recruitmentCluesPhone) {
        this.recruitmentCluesPhone = recruitmentCluesPhone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Organization getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Organization organization_id) {
        this.organization_id = organization_id;
    }
}
