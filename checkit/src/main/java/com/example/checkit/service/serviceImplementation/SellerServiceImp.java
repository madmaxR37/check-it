package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.SellerDto;
import com.example.checkit.dto.mappers.SellerMapper;
import com.example.checkit.model.Seller;
import com.example.checkit.repository.SellerRepository;
import com.example.checkit.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImp implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImp(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public SellerDto createSeller(SellerDto sellerDto) {
        Seller seller= sellerRepository.save(SellerMapper.sellerDtoToSeller(sellerDto));
        return SellerMapper.sellerToSellerDto(seller);
    }

    @Override
    public SellerDto updateSeller(SellerDto sellerDto) {
        return null;
    }

    @Override
    public List<SellerDto> findAllSellers() {
        Iterable<Seller> sellers = sellerRepository.findAll();
        return null;
    }

    @Override
    public void deleteSeller(Long id) {
       Optional<Seller> seller = sellerRepository.findById(id);
        seller.ifPresent(value -> sellerRepository.delete(value));
    }
}
