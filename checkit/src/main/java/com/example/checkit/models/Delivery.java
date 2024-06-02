package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Accessors(chain = true)
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String deliveryTitle;

    @Column(name = "cost")
    private Float deliveryCost;

    @Column(name = "acceptanceStatus")
    private Boolean acceptanceStatus;

    private Boolean paymentStatus;

    private Boolean assignationStatus;

    private String description;

    private String sellerPhoneNumber;

    private Boolean deliveryStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @Embedded
    private Address sellerLocation;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "deliveryMan_id")
    private DeliveryMan deliveryMan;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

}
