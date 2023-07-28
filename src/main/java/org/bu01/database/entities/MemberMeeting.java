package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class MemberMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meetingId;
    @OneToMany(mappedBy = "memberMeeting")
    private List<Member> memberId;
}
