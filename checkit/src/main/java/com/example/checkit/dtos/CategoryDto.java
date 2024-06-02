package com.example.checkit.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CategoryDto {

    private Long id;


    @NotBlank(message = "category must have a name")
    private String name;


    private Boolean isActive;

}
