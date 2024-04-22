package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
public class PreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_orderId")
    private Integer id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_contact")
    private String clientPhoneNumber;

    @Column(name = "distance")
    private Long tripDistance;

    @Column(name = "delivery_cost")
    private Float deliveryCost;

    @Column(name = "total_cost")
    private Float totalCost;

    @Embedded
    @Column(name = "client_localisation")
    private Address clientAddress;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card card;


}
