package com.example.checkit.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Entity
@Accessors(chain = true)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardid")
    private Long id;


    private String name;

    private Boolean isActiveStatus;

    private Integer totalItemsQuantity;

    private Float totalItemsCost;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PurchaseLine> purchaseLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

}
