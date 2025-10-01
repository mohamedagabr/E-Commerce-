package com.gabr.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private int cartId;
    private Set<ProductDto> products = new HashSet<>();
    private UserDto user;
}
