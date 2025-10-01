package com.gabr.e_commerce.controller;

import com.gabr.e_commerce.dto.CartDto;
import com.gabr.e_commerce.response.ApiResponse;
import com.gabr.e_commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carts")

public class CartController {
    private final CartService cartService;
    @PostMapping("/add-product/{id}")
    public ResponseEntity<ApiResponse<CartDto>> addProductToCart(@PathVariable  int productId){
        CartDto save = cartService.addProductToCart(productId);
        return ResponseEntity.ok(new ApiResponse<>("Successfully Added",save));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<CartDto>> getCart(){
        CartDto cart = cartService.getCart();
        return ResponseEntity.ok(new ApiResponse<>("Successfuly",cart));
    }


}
