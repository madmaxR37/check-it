package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.model.Category;

public class CategoryMapper {

    public static Category categoryDtoTOCategory(CategoryDto categoryDto){

        return new Category()
                .setId(categoryDto.getId())
                .setName(categoryDto.getName())
                .setIsActive(categoryDto.getIsActive());

    }

    public static CategoryDto categorytoCategoryDto(Category category){

        return new CategoryDto()
                .setId(category.getId())
                .setName(category.getName())
                .setIsActive(category.getIsActive())
                ;
    }
}
