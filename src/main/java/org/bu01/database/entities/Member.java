package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "member_code")
    private String memberCode;
    @Column(name = "need_find_job")
    private boolean needFindJob;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "interested_career")
    private String interestedCareer;
    @Column(name = "note")
    private String note;
    @OneToOne
    @JoinColumn(name = "cv_id")
    private CurriculumVitae cvId;
    @Column(name = "gender")
    private int gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "id_passport")
    private String id_passport;
    @Column(name = "experience_year")
    private int experienceYear;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "refer_email")
    private String referEmail;
    @Column(name = "modified_date")
    private LocalDate modifiedDate;
    @ManyToOne
    @JoinColumn(name = "member_meeting")
    private MemberMeeting memberMeeting;
    @OneToMany(mappedBy = "memberId")
    private List<Certificate> certificate;
    @OneToMany(mappedBy = "memberId")
    private List<Education> education;
    @OneToMany(mappedBy = "memberId")
    private List<Experience> experience;
    @OneToMany(mappedBy = "memberId")
    private List<RecruitmentApplied> recruitmentApplied;
}
