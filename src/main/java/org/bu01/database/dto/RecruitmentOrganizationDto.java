package org.bu01.database.dto;

import org.bu01.database.entities.Organization;

import java.util.Date;
import java.util.UUID;

public class RecruitmentOrganizationDto {
    public static class RequestRecruitmentOrganization{
        private int isPrivate = 0;
        private Date effectiveStartDate;

        private Date effectiveEndDate;

        private int isActive = 0;

        private int scope;

        private String officeAddress;

        private String recruitmentClues;

        private String recruitmentCluesEmail;

        private String recruitmentCluesPhone;

        private String information;

        private String organization_code;


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

        public String getRecruitmentClues() {
            return recruitmentClues;
        }

        public void setRecruitmentClues(String recruitmentClues) {
            this.recruitmentClues = recruitmentClues;
        }

        public int getIsPrivate() {
            return isPrivate;
        }

        public void setIsPrivate(int isPrivate) {
            this.isPrivate = isPrivate;
        }

        public String getRecruitmentCluesEmail() {
            return recruitmentCluesEmail;
        }

        public void setRecruitmentCluesEmail(String recruitmentCluesEmail) {
            this.recruitmentCluesEmail = recruitmentCluesEmail;
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

        public String getOrganizationCode() {
            return organization_code;
        }

        public void setOrganizationCode(String organization_code) {
            this.organization_code = organization_code;
        }
    }

    public static class ResponseRecruitment{
        private UUID recruitment_organization_id;
        private Organization organization_id;
        private int scope;
        private Date effectiveStartDate;

        private Date effectiveEndDate;
        private String address;
        private int isActive;

        public UUID getRecruitment_organization_id() {
            return recruitment_organization_id;
        }

        public void setRecruitment_organization_id(UUID recruitment_organization_id) {
            this.recruitment_organization_id = recruitment_organization_id;
        }

        public Organization getOrganization_id() {
            return organization_id;
        }

        public void setOrganization_id(Organization organization_id) {
            this.organization_id = organization_id;
        }

        public int getScope() {
            return scope;
        }

        public void setScope(int scope) {
            this.scope = scope;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIsActive() {
            return isActive;
        }

        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }
    }
}
