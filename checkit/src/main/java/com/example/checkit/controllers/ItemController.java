package com.example.checkit.controllers;

import com.example.checkit.dtos.ItemDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.ItemServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("check-it/v1/item")
public class ItemController {

    private final ItemServiceImp itemServiceImp;

    public ItemController(ItemServiceImp itemServiceImp) {
        this.itemServiceImp = itemServiceImp;
    }

    @PostMapping("/create/{sellerId}/{categoryIds}")
    public ResponseEntity<Object> createItem(@Validated  @RequestPart("data") ItemDto itemDto,
                                             @PathVariable Long sellerId,
                                             @PathVariable List<Long> categoryIds,
                                              @RequestPart("files") List<MultipartFile> files){
        ItemDto itemDtoEntity = itemServiceImp.createItem(itemDto,sellerId,categoryIds, files);
         return ResponseHandler.generateResponseData("Item created successfully", HttpStatus.CREATED,itemDtoEntity);
    }
}
