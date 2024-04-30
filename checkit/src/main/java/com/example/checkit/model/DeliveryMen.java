package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Entity
@Data
public class DeliveryMen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "deliveryman_id")
    private List<DeliveryMan> deliveryMEN;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
