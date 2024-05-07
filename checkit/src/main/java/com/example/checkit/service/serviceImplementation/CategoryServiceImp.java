package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.dto.mappers.CategoryMapper;
import com.example.checkit.repository.CategoryRepository;
import com.example.checkit.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImp implements CategoryService {


    private final CategoryRepository categoryRepository;


    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        categoryDto.setIsActive(true);
        return CategoryMapper.categoryToCategoryDto(categoryRepository.save(CategoryMapper.categoryDtoToCategory(categoryDto)));
    }

    @Override
    public List<CategoryDto> findAll() {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
