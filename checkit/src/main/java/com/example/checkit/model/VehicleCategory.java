package com.example.checkit.model;

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
    @Column(name = "vehiclecategory_id")
    private Long id;

    private String name;

    private Boolean isActive;

    private String svgUrl ;

    @OneToMany(mappedBy = "vehicleCategory")
    private List<Vehicle> vehicles;

}
