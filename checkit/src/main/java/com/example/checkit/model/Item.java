package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
@Accessors(chain = true)
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private Integer id;

    private String itemName;

    private Integer quantity;

    private Float unitPrice;

    private String itemDescription;

    @ElementCollection
    @CollectionTable(
            name = "itemimages",
            joinColumns = @JoinColumn(name = "item_id")
    )
    @Column(name = "imagesurl")
    private List<String> itemImages;

    @Column(name = "itemstatus")
    private Boolean availableStatus;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable( name = "item_category",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name="category_id"))
    private List<Category> categories;


}
