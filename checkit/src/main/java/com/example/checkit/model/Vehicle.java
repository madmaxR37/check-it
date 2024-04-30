package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "matriculation")
    private String matriculation;

    @ManyToOne
    @JoinColumn(name = "vehicleCategory_id")
    private VehicleCategory vehicleCategory;
}

