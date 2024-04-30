package com.example.checkit.repository;

import com.example.checkit.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
}
