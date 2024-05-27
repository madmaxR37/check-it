package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.ItemDto;
import com.example.checkit.dto.mappers.CategoryMapper;
import com.example.checkit.dto.mappers.ItemMapper;
import com.example.checkit.model.Category;
import com.example.checkit.model.Item;
import com.example.checkit.model.Seller;
import com.example.checkit.model.User;
import com.example.checkit.repository.CategoryRepository;
import com.example.checkit.repository.ItemRepository;
import com.example.checkit.repository.UserRepository;
import com.example.checkit.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;


    public ItemServiceImp(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto, Long sellerId, List<Long> categoryIds ) {

        Optional<User> user= userRepository.findById(sellerId);
        List<Category> categories = new ArrayList<>();
        for (Long categoryId: categoryIds){
            Optional<Category> category= categoryRepository.findById(categoryId);
            if (category.isPresent()){
                Category categoryModel = category.get();
                categories.add(categoryModel);
            }
        }
        if (user.isPresent()){
            Item item =
                    ItemMapper.itemDtoToItem(itemDto)
                            .setSeller((Seller) user.get())
                            .setCategories(CategoryMapper.categoryDtosTOCategories(CategoryMapper.categoriestoCategoryDtos(categories)));
            return ItemMapper.itemToItemDto(itemRepository.save(item));
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
