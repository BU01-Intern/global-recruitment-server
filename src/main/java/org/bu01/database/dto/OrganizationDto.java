package org.bu01.database.dto;


import org.bu01.database.entities.Organization;

import java.util.Date;
import java.util.UUID;

public class OrganizationDto {
    private UUID organization_id;
    private String name;
    private String code;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private UUID parentId;

    public UUID getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(UUID organization_id) {
        this.organization_id = organization_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}
