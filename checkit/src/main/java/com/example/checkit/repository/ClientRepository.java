package com.example.checkit.repository;

import com.example.checkit.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Long> {

    Optional<Client> findClientByEmailOrPhoneNumber(String email, String phone);

    Optional<Client> findClientByEmail(String email);
}
