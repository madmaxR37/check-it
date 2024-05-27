package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.dto.mappers.ItemMapper;
import com.example.checkit.dto.mappers.PurchaseLineMapper;
import com.example.checkit.model.Item;
import com.example.checkit.model.PurchaseLine;
import com.example.checkit.repository.ItemRepository;
import com.example.checkit.repository.PurchaseLineRepository;
import com.example.checkit.service.PurchaseLineService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PurchaseLineServiceImp implements PurchaseLineService {

    private final ItemRepository itemRepository;

    private final PurchaseLineRepository purchaseLineRepository;

    public PurchaseLineServiceImp(ItemRepository itemRepository, PurchaseLineRepository purchaseLineRepository) {
        this.itemRepository = itemRepository;
        this.purchaseLineRepository = purchaseLineRepository;
    }

    @Override
    public Long createPurchaseLine(Long itemId, PurchaseLineDto purchaseLineDto) {
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()){
            Item itemModel = item.get();
            purchaseLineDto.setItemDto(ItemMapper.itemToItemDto(itemModel));
            PurchaseLine purchaseLine = purchaseLineRepository.save(PurchaseLineMapper.purchaseLineDtoToPurchaseLine(purchaseLineDto));
            return purchaseLine.getId();
        }
        return null;
    }

    @Override
    public void deletePurchaseLine(Long purchaseLineId) {

    }
}
