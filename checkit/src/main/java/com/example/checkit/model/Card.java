package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardid")
    private Integer id;

    private Boolean isActiveStatus;

    private Integer totalItemsQuantity;

    private Float totalItemsCost;

    @OneToMany
    @JoinColumn(name = "purchaseline_id")
    private List<PurchaseLine> purchaseLine;
}
