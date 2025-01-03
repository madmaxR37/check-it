package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
@Accessors(chain = true)
@DiscriminatorValue("seller")
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Seller extends User{

    @ElementCollection
    @CollectionTable(
            name = "nic_images",
            joinColumns = @JoinColumn(name= "seller_id")
    )
    @Column(name="nationalId")
    private List<String> nationalId;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "seller"
    )
    private List<Item> items;

    @OneToMany
    @JoinColumn(name = "orders_id")
    private List<OrderEntity> orderEntities;

    @OneToMany
    @JoinColumn(name = "transaction_id")
    private List<Transaction> transactions;

    @OneToMany(
            mappedBy = "seller"
    )
    private List<Delivery> deliveries;
}
