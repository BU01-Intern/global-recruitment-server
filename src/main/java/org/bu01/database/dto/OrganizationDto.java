package org.bu01.database.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class OrganizationDto {
    private String name;
    private String code;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private String parentId;

}
