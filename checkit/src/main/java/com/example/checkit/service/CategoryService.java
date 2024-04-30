package com.example.checkit.service;

import com.example.checkit.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategoryDto categoryDto);

    List<CategoryDto> findAll();

    CategoryDto update(CategoryDto categoryDto);

    void delete(Long id);
}
