package com.example.checkit.dto.mappers;

import com.example.checkit.dto.ItemDto;
import com.example.checkit.model.Item;

public class ItemMapper {

    public static Item itemDtoToItem(ItemDto itemDto){

        return new Item()
                .setItemName(itemDto.getItemName())
                .setItemDescription(itemDto.getItemDescription())
                .setQuantity(itemDto.getQuantity())
                .setUnitPrice(itemDto.getUnitPrice())
                .setAvailableStatus(itemDto.getAvailableStatus())
                .setItemImages(itemDto.getItemImages());
    }

    public static ItemDto itemToItemDto(Item item){

        return new ItemDto()
                .setItemName(item.getItemName())
                .setItemDescription(item.getItemDescription())
                .setQuantity(item.getQuantity())
                .setUnitPrice(item.getUnitPrice())
                .setAvailableStatus(item.getAvailableStatus())
                .setItemImages(item.getItemImages());
    }
    //TODO map category
}
