package com.example.checkit.repositories;

import com.example.checkit.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<Object> findUserByEmailOrPhoneNumber(String email, String phone);
}
