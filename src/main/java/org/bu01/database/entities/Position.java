package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "position_name")
    private String positionName;
    @Column(name = "num_employee")
    private int numEmployee;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "position")
    private List<RecruitmentInformation> recruitmentInformation;
}
