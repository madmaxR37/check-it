package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String deliveryTitle;

    @Column(name = "cost")
    private Float deliveryCost;

    @Column(name = "acceptanceStatus")
    private Boolean acceptanceStatus;

    private String description;

    private String sellerPhoneNumber;

    private Boolean deliveryStatus;

    @Embedded
    private Address sellerLocation;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "deliveryMan_id")
    private DeliveryMan deliveryMan;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
