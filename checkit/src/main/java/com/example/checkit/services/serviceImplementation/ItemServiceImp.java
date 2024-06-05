package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.ItemDto;
import com.example.checkit.dtos.mappers.ItemMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Category;
import com.example.checkit.models.Item;
import com.example.checkit.models.Seller;
import com.example.checkit.models.User;
import com.example.checkit.repositories.CategoryRepository;
import com.example.checkit.repositories.ItemRepository;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.ItemService;
import com.example.checkit.services.externalServices.S3BucketService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    private final S3BucketService bucketService;

    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;


    public ItemServiceImp(ItemRepository itemRepository, S3BucketService bucketService, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.bucketService = bucketService;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ItemDto createItem(ItemDto itemDto, Long sellerId, List<Long> categoryIds, List<MultipartFile> files) {

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

            List<String> imageUrls = bucketService.uploadFiles(files);
            Item item =
                    ItemMapper.itemDtoToItem(itemDto)
                            .setItemImages(imageUrls)
                            .setSeller((Seller) user.get())
                            .setAvailableStatus(true);
            item.setCategories(categories);
            return ItemMapper.itemToItemDto(itemRepository.save(item));
        }
        throw new EntityNotFoundException("this user doesn't exist", HttpStatus.NOT_FOUND);
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
