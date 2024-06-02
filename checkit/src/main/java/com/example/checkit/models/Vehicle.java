package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    @Column(unique = true)
    private String matriculation;

    @ManyToOne
    @JoinColumn(name = "vehicleCategory_id")
    private VehicleCategory vehicleCategory;
}

