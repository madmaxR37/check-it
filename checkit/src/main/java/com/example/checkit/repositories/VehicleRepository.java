package com.example.checkit.repositories;

import com.example.checkit.models.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
}
