package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class PurchaseLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchaseid")
    private Integer id;

    @Column(name = "purchase_qty")
    private Integer quantity;

    @Column(name = "price")
    private Float price;
}
