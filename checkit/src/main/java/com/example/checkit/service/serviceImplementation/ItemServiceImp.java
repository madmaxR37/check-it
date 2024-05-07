package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.dto.ItemDto;
import com.example.checkit.dto.mappers.CategoryMapper;
import com.example.checkit.dto.mappers.ItemMapper;
import com.example.checkit.model.Item;
import com.example.checkit.model.Seller;
import com.example.checkit.repository.ItemRepository;
import com.example.checkit.repository.SellerRepository;
import com.example.checkit.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    private final SellerRepository sellerRepository;

    public ItemServiceImp(ItemRepository itemRepository, SellerRepository sellerRepository) {
        this.itemRepository = itemRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto, Long sellerId, List<CategoryDto> categoryDtos) {
        Optional<Seller> seller= sellerRepository.findById(sellerId);
        if (seller.isPresent()){
            Item item =
                    ItemMapper.itemDtoToItem(itemDto)
                            .setSeller(seller.get())
                            .setCategories(CategoryMapper.categoryDtosTOCategories(categoryDtos));
            itemRepository.save(item);
        }
        return null;
    }

    @Override
    public ItemDto updateItem(ItemDto itemDto) {
        return null;
    }

    @Override
    public List<ItemDto> findAllItems() {
        return null;
    }

    @Override
    public List<ItemDto> findItemsByName(String name) {
        return null;
    }

    @Override
    public List<ItemDto> findItemsByCategory(String category) {
        return null;
    }
}
