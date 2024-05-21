package com.example.checkit.repository;


import com.example.checkit.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findUserByEmail(String email);
}
