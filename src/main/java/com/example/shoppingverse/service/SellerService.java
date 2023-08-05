package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.request.SellerRequestDto;
import com.example.shoppingverse.dto.response.SellerReponseDto;
import com.example.shoppingverse.model.Seller;
import com.example.shoppingverse.repository.SellerRepository;
import com.example.shoppingverse.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public SellerReponseDto addSeller(SellerRequestDto sellerRequestDto) {
        //dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSEller(sellerRequestDto);

        //save the entity
        Seller savedSeller = sellerRepository.save(seller);

        // prepare response dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);

    }
}
