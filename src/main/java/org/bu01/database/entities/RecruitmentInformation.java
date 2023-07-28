package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class RecruitmentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "min_salary")
    private int minSalary;
    @Column(name = "max_salary")
    private int maxSalary;
    @Column(name = "currency")
    private String currency;
    @Column(name = "vacancies")
    private String vacancies;
    @Column(name = "num_employee")
    private int numEmployee;
    @Column(name = "status")
    private int status;
    @Column(name = "recruitment_career_id")
    private int recruitmentCareerId;
    @Column(name = "job_level")
    private String jobLevel;
    @Column(name = "contract_type")
    private String contractType;
    @Column(name = "province_id")
    private int provinceId;
    @Column(name = "email")
    private String email;
    @Column(name = "work_time")
    private int workTime; //????
    @Column(name = "content")
    private String content;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_requirement")
    private String jobRequirement;
    @Column(name = "job_treatment")
    private String jobTreatment;
    @Column(name = "job_other")
    private String jobOther;
    @ManyToOne
    @JoinColumn(name = "recruitment_type")
    private Category recruitmentType;
    @ManyToOne
    @JoinColumn(name = "recruitment_timeline_infomation_id")
    private RecruitmentTimelineInformation recruitmentTimelineInformation;
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;
}
