package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Litigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String litigationTitle;

    @Column(name="detail")
    private String litigationDetail;

    @Column(name="resolutionStatus")
    private Boolean resolvedStatus;

}
