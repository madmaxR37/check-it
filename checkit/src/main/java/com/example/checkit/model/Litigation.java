package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Accessors(chain = true)
@Data
@Entity
public class Litigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String litigationTitle;

    @Column(name="detail")
    private String litigationDetail;

    @Column(name="resolutionStatus")
    private Boolean resolvedStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
