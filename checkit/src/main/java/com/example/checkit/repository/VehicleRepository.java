package com.example.checkit.repository;

import com.example.checkit.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
}
