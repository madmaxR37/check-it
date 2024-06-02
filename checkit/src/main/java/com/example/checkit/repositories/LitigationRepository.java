package com.example.checkit.repositories;

import com.example.checkit.models.Litigation;
import org.springframework.data.repository.CrudRepository;

public interface LitigationRepository extends CrudRepository<Litigation,Long> {
}
