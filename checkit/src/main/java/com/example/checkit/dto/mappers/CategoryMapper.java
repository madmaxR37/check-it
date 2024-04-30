package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static List<Category> categoryDtoTOCategory(List<CategoryDto> categoryDtos){

        List<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto: categoryDtos){
            Category category = new Category()
                    .setId(categoryDto.getId())
                    .setName(categoryDto.getName())
                    .setIsActive(categoryDto.getIsActive());
            categories.add(category);
        }


        return categories;
    }

    public static List<CategoryDto> categorytoCategoryDto(List<Category> categories){

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for (Category category: categories){
            CategoryDto categoryDto = new CategoryDto()
                    .setId(category.getId())
                    .setName(category.getName())
                    .setIsActive(category.getIsActive())
                    .setItemDtos(ItemMapper.itemsToItemsDto(category.getItems()));
            categoryDtos.add(categoryDto);
        }


        return categoryDtos;
    }
}
