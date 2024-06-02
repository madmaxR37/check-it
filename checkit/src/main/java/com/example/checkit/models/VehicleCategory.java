package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Accessors(chain = true)
@Data
@Entity
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Boolean isActive;

    private String svgUrl ;

    @OneToMany(mappedBy = "vehicleCategory")
    private List<Vehicle> vehicles;

}
