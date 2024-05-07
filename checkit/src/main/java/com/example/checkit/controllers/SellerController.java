package com.example.checkit.controllers;

import com.example.checkit.dto.SellerDto;
import com.example.checkit.service.serviceImplementation.SellerServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/seller")
public class SellerController {

    private final SellerServiceImp sellerServiceImp;

    public SellerController(SellerServiceImp sellerServiceImp) {
        this.sellerServiceImp = sellerServiceImp;
    }

    @PostMapping("/save")
    public SellerDto createSeller(@RequestBody SellerDto sellerDto){
        return sellerServiceImp.createSeller(sellerDto);
    }

}
