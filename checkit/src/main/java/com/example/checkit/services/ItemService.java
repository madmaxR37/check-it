package com.example.checkit.services;

import com.example.checkit.dtos.ItemDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemDto createItem(ItemDto itemDto, Long sellerId, List<Long> categoryIds, List<MultipartFile> files);

    ItemDto updateItem(ItemDto itemDto);

    List<ItemDto> findAllItems();

    List<ItemDto> findItemsByName(String name);

    List<ItemDto> findItemsByCategory(String category);
}
