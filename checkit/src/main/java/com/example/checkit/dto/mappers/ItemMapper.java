package com.example.checkit.dto.mappers;

import com.example.checkit.dto.ItemDto;
import com.example.checkit.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemMapper {

    public static List<Item> itemsDtoToItems(List<ItemDto> itemDtos){

        List<Item> items = new ArrayList<>();

        for (ItemDto itemDto: itemDtos){
           Item item = new Item()
                    .setItemName(itemDto.getItemName())
                    .setItemDescription(itemDto.getItemDescription())
                    .setQuantity(itemDto.getQuantity())
                    .setUnitPrice(itemDto.getUnitPrice())
                    .setAvailableStatus(itemDto.getAvailableStatus())
                    .setItemImages(itemDto.getItemImages());
           items.add(item);
        }
        return items;
    }

    public static List<ItemDto> itemsToItemsDto(List<Item> items){

         List<ItemDto> itemDtos = new ArrayList<>();

         for (Item item: items){
             ItemDto itemDto = new ItemDto()
                     .setId(item.getId())
                     .setSellerId(item.getSeller().getId())
                     .setItemName(item.getItemName())
                     .setItemDescription(item.getItemDescription())
                     .setSellerDto(SellerMapper.sellerToSellerDto(item.getSeller()))
                     .setQuantity(item.getQuantity())
                     .setUnitPrice(item.getUnitPrice())
                     .setAvailableStatus(item.getAvailableStatus())
                     .setItemImages(item.getItemImages())
                     .setCreatedDate(item.getCreatedDate())
                     .setCategories(CategoryMapper.categoriestoCategoryDtos(item.getCategories()));
             itemDtos.add(itemDto);
         }
        return itemDtos;
    }
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
                .setId(item.getId())
                .setSellerId(item.getSeller().getId())
                .setItemName(item.getItemName())
                .setSellerDto(SellerMapper.sellerToSellerDto(item.getSeller()))
                .setItemDescription(item.getItemDescription())
                .setQuantity(item.getQuantity())
                .setUnitPrice(item.getUnitPrice())
                .setAvailableStatus(item.getAvailableStatus())
                .setItemImages(item.getItemImages())
                .setCreatedDate(item.getCreatedDate())
                .setCategories(CategoryMapper.categoriestoCategoryDtos(item.getCategories()));

    }
}
