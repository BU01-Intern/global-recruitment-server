package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Column(name = "end_time")
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "meeting_type")
    private Category meetingType;
    @Column(name = "meeting_title")
    private String meetingTitle;
    @Column(name = "host_by")
    private String hostBy;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "createdBy")
    private String createdBy;
    @Column(name = "note")
    private String note;
    @Column(name = "send_email")
    private boolean sendEmail;
    @ManyToOne
    @JoinColumn(name = "recruitment_timeline_id")
    private RecruitmentTimelineInformation recruitmentTimelineId;
    @OneToMany(mappedBy = "meetingId")
    private List<MemberMeeting> memberMeeting;
}
