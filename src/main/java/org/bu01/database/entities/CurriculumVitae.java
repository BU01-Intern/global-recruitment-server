package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class CurriculumVitae {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "worked_at_viettel")
    private boolean workedAtViettel;
    @Column(name = "expected_salary")
    private int expectedSalary;
    @Column(name = "out_standing")
    private String outStanding;
    @Column(name = "skill")
    private String skill;
    @Column(name = "ref_full_name")
    private String refFullName;
    @Column(name = "ref_email")
    private String refEmail;
    @Column(name = "ref_relation")
    private String refRelation;
    @Column(name = "ref_position")
    private String refPosition;
}
