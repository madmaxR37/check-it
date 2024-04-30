package com.example.checkit.service;

import com.example.checkit.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto createItem(ItemDto itemDto);

    ItemDto updateItem(ItemDto itemDto);

    List<ItemDto> findAllItems();

    List<ItemDto> findItemsByName(String name);

    List<ItemDto> findItemsByCategory(String category);
}
