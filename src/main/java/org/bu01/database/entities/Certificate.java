package org.bu01.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

@Entity
@Data
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "certificate_year")
    private LocalDate certificateYear;
    @Column(name = "certificate_place")
    private String certificatePlace;
    @Column(name = "result")
    private String result;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
}
