package com.example.checkit.models;

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
    private Long id;

    @Column(name = "purchase_qty")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
