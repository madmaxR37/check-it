package com.example.checkit.repository;

import com.example.checkit.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
