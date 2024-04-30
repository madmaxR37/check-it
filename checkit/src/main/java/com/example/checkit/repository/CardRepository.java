package com.example.checkit.repository;

import com.example.checkit.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {


    Optional<Card> findByName(String name);
}
