package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class RecruitmentTimelineInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recruitment_timeline_id")
    private UUID id;
    @Column(name = "status")
    private int status;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "recruitment_organization_id")
    private RecruitmentOrganization recruitmentOrganizationId;
    @ManyToOne
    @JoinColumn(name = "recruitment_type")
    private Category recruitmentType;
    @OneToMany(mappedBy = "recruitmentTimelineId")
    private List<Meeting> meeting;
    @OneToMany(mappedBy = "recruitmentTimelineInformation")
    private List<RecruitmentInformation> recruitmentInformation;
}
