package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.CategoryDto;
import com.example.checkit.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static  Category categoryDtoToCategory(CategoryDto categoryDto){
        return new Category().setName(categoryDto.getName())
                             .setIsActive(categoryDto.getIsActive());

    }

    public static CategoryDto categoryToCategoryDto(Category category){
        return new CategoryDto()
                .setId(category.getId())
                .setName(category.getName())
                .setIsActive(category.getIsActive());
    }
    public static List<Category> categoryDtosTOCategories(List<CategoryDto> categoryDtos){

        List<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto: categoryDtos){
            Category category = new Category()
                    .setName(categoryDto.getName())
                    .setIsActive(categoryDto.getIsActive());
            categories.add(category);
        }


        return categories;
    }

    public static List<CategoryDto> categoriestoCategoryDtos(List<Category> categories){

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category: categories){
            CategoryDto categoryDto = new CategoryDto()
                    .setId(category.getId())
                    .setName(category.getName())
                    .setIsActive(category.getIsActive());
            categoryDtos.add(categoryDto);
        }


        return categoryDtos;
    }

}
