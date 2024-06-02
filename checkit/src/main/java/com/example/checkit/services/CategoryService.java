package com.example.checkit.services;

import com.example.checkit.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategoryDto categoryDto);

    List<CategoryDto> findAll();

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long id);
}
