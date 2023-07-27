package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "company")
    private String company;
    @Column(name = "position")
    private String position;
    @Column(name = "start_date_show")
    private LocalDate startDateShow;
    @Column(name = "end_date_show")
    private LocalDate endDateshow;
    @Column(name = "description")
    private String description;
    @Column(name = "is_current")
    private boolean isCurrent;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
}
