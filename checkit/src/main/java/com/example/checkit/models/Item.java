package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Accessors(chain = true)
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private Long id;

    private String itemName;

    private Float unitPrice;

    private String itemDescription;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

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
