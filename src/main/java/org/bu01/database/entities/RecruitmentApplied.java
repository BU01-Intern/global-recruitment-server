package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class RecruitmentApplied {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "status")
    private int status;
    @Column(name = "english_score")
    private float englishScore;
    @Column(name = "interview_score")
    private float interviewScore;
    @Column(name = "skill_score")
    private float skillScore;
    @Column(name = "other")
    private String other;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
}
