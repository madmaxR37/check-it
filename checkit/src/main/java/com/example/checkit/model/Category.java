package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Entity
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_status")
    private Boolean isActive;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "categories"
    )
    private List<Item> items;
}
