package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.CategoryDto;
import com.example.checkit.dtos.mappers.CategoryMapper;
import com.example.checkit.exceptions.EntityAlreadyExistException;
import com.example.checkit.models.Category;
import com.example.checkit.repositories.CategoryRepository;
import com.example.checkit.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImp implements CategoryService {


    private final CategoryRepository categoryRepository;


    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Optional<Category> category = categoryRepository.findByName(categoryDto.getName());
        if (category.isEmpty()){
            categoryDto.setIsActive(true);
            return CategoryMapper.categoryToCategoryDto(categoryRepository.save(CategoryMapper.categoryDtoToCategory(categoryDto)));
        }
        throw new EntityAlreadyExistException("category " + categoryDto.getName() +" already exist ",
                HttpStatus.BAD_REQUEST);

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
