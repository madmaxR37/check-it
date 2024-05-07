package com.example.checkit.service;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.dto.ItemDto;
import com.example.checkit.dto.SellerDto;

import java.util.List;

public interface ItemService {

    ItemDto createItem(ItemDto itemDto, Long sellerId, List<CategoryDto> categoryDtos);

    ItemDto updateItem(ItemDto itemDto);

    List<ItemDto> findAllItems();

    List<ItemDto> findItemsByName(String name);

    List<ItemDto> findItemsByCategory(String category);
}
