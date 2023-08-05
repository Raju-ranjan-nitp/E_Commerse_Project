package com.example.shoppingverse.transformer;

import com.example.shoppingverse.dto.request.CustomerRequestDto;
import com.example.shoppingverse.dto.response.CustomerResponseDto;
import com.example.shoppingverse.model.Customer;
import lombok.experimental.UtilityClass;

//@UtilityClass (optional)//for ensuring class is not unstansiated but not a standard practice to write

public class CustomerTransformer {
    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
          Customer customer = Customer.builder().name(customerRequestDto.getName())
                .gender(customerRequestDto.getGender())
                .mobNo(customerRequestDto.getMobNo())
                .emailId(customerRequestDto.getEmailId()).build();
        return customer;

    }
    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder().name(customer.getName())
                .gender(customer.getGender())
                .emailId(customer.getEmailId())
                .mobNo(customer.getMobNo()).build();
        return customerResponseDto ;
    }
}
