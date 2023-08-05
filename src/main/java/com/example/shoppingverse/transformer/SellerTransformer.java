package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.request.SellerRequestDto;
import com.example.shoppingverse.dto.response.SellerReponseDto;
import com.example.shoppingverse.model.Seller;

public class SellerTransformer {

    public static Seller SellerRequestDtoToSEller(SellerRequestDto sellerRequestDto){
        return Seller.builder().name(sellerRequestDto.getName())
                .panNo(sellerRequestDto.getPanNo())
                .emailId(sellerRequestDto.getEmailId())
                .build();

    }
    public static SellerReponseDto SellerToSellerResponseDto(Seller seller){
        return SellerReponseDto.builder()
                .name(seller.getName())
                .emailId(seller.getEmailId())
                .build();
    }
}
