package com.example.checkit.repository;

import com.example.checkit.model.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {


    Optional<Cart> findByName(String name);
}
