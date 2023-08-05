package com.example.shoppingverse.service;

import com.example.shoppingverse.dto.request.CustomerRequestDto;
import com.example.shoppingverse.dto.response.CustomerResponseDto;
import com.example.shoppingverse.model.Cart;
import com.example.shoppingverse.model.Customer;
import com.example.shoppingverse.repository.CustomerRepository;
import com.example.shoppingverse.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {

        //dto -> entity
//        Customer customer = new Customer();
//        //setting parameter for customer
//        customer.setName(customerRequestDto.getName());
//        customer.setGender(customerRequestDto.getGender());
//        customer.setEmailId (customerRequestDto.setEmailId());
//        customer.setMobNo(customerRequestDto.getMobNo());

        //using builder
//        Customer customer = Customer.builder().name(customerRequestDto.getName())
//                .gender(customerRequestDto.getGender())
//                .mobNo(customerRequestDto.getMobNo())
//                .emailId(customerRequestDto.getEmailId()).build();
        // above coad is shifted in transformer
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer); //save both customer and cart

        // prepare the response Dto
//        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder().name(savedCustomer.getName())
//                .gender(savedCustomer.getGender())
//                .emailId(savedCustomer.getEmailId())
//                .mobNo(savedCustomer.getMobNo()).build();

        //above coad is shifted in transformer

        //return customerResponseDto;
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);




    }
}
