package com.example.checkit.models;

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
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_contact")
    private String clientPhoneNumber;

    @Column(name = "distance")
    private Float tripDistance;

    @Column(name = "delivery_cost")
    private Float deliveryCost;

    @Column(name = "total_cost")
    private Float totalCost;

    @Embedded
    @Column(name = "client_localisation")
    private Address clientAddress;


    @OneToOne
    @JoinColumn(name = "card_id")
    private Cart cart;


}
