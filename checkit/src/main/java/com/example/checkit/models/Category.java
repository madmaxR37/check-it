package com.example.checkit.models;

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
    private Long id;

    @Column(unique = true)
    private String name;

    private Boolean isActive;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "categories"
    )
    private List<Item> items;
}
