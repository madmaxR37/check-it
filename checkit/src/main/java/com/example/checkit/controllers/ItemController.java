package com.example.checkit.controllers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.dto.ItemDto;
import com.example.checkit.handler.ResponseHandler;
import com.example.checkit.service.serviceImplementation.ItemServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("check-it/v1/item")
public class ItemController {

    private final ItemServiceImp itemServiceImp;

    public ItemController(ItemServiceImp itemServiceImp) {
        this.itemServiceImp = itemServiceImp;
    }

    @PostMapping("/create/{sellerId}/{categoryIds}")
    public ResponseEntity<Object> createItem(@RequestBody ItemDto itemDto, @PathVariable Long sellerId, @PathVariable List<Long> categoryIds){
        ItemDto itemDtoEntity = itemServiceImp.createItem(itemDto,sellerId,categoryIds);
         return ResponseHandler.generateResponseData("Item created successfully", HttpStatus.CREATED,itemDtoEntity);
    }
}
