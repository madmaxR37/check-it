package com.example.checkit.service;

import com.example.checkit.dto.SellerDto;

import java.util.List;

public interface SellerService {

    SellerDto createSeller(SellerDto sellerDto);

    SellerDto updateSeller(SellerDto sellerDto);

    List<SellerDto> findAllSellers();

    void deleteSeller(Long id);
}
