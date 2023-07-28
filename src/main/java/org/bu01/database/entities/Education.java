package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "special")
    private String special;
    @Column(name = "educational_level_id")
    private int educationalLevelId;
    @Column(name = "type")
    private String type;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "graduate_year")
    private int graduateYear;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
}
