package com.gabr.e_commerce.controller;

import com.gabr.e_commerce.dto.ProductDto;
import com.gabr.e_commerce.response.ApiResponse;
import com.gabr.e_commerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // my First Solution by use ProductDto
//    @PostMapping
//    public ResponseEntity<ProductDto> addProduct1(@Valid @RequestBody ProductDto productDto) {
//        return ResponseEntity.ok(productService.addProduct(productDto));
//    }
    //  second Solution by use ApiResponse
    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> addProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto save = productService.addProduct(productDto);
        return ResponseEntity.ok(new ApiResponse("Successfuly Added",save));
    }



    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts(){
        List<ProductDto> list = productService.getAllProducts1();
        return ResponseEntity.ok(new ApiResponse("Successfuly", list));
    }
}
