package com.example.checkit.repositories;

import com.example.checkit.models.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {


    Optional<Cart> findByName(String name);
}
