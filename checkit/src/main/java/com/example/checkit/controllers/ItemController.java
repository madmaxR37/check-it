package com.example.checkit.controllers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.dto.ItemDto;
import com.example.checkit.service.serviceImplementation.ItemServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("check-it/v1/item")
public class ItemController {

    private final ItemServiceImp itemServiceImp;

    public ItemController(ItemServiceImp itemServiceImp) {
        this.itemServiceImp = itemServiceImp;
    }

    @PostMapping("/create/{sellerId}")
    public ItemDto createItem(@RequestBody ItemDto itemDto, @PathVariable Long sellerId,@RequestBody List<CategoryDto> categoryDtos){
         return itemServiceImp.createItem(itemDto,sellerId,categoryDtos);
    }
}
