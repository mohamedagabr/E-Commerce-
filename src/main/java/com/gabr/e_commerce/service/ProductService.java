package com.gabr.e_commerce.service;

import com.gabr.e_commerce.dto.ProductDto;
import com.gabr.e_commerce.exception.ResourseNotFound;
import com.gabr.e_commerce.mapper.ProductMapper;
import com.gabr.e_commerce.model.Category;
import com.gabr.e_commerce.model.Product;
import com.gabr.e_commerce.repository.CategoryRepository;
import com.gabr.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Category category = categoryRepository.findByCategoryName(productDto.getCategoryName())
                .orElseThrow(() -> new ResourseNotFound("Category With Name ("
                        + productDto.getCategoryName() + ") Not Found"));
        Product product = productMapper.toEntity(productDto);
        product.setCategory(category);
        Product save = productRepository.save(product);
        return productMapper.toDto(save);
    }
    // First Solution by use List<ProductDto> toDto(List<Product> products);
    public List<ProductDto> getAllProducts1(){
        List<Product> list =  productRepository.findAll() ;
        return productMapper.toDto(list) ;
    }

    // Second Solution by use Java 8 Stream API
    public List<ProductDto> getAllProducts2(){
       List<Product> list =  productRepository.findAll() ;
       return list.stream().map(productMapper::toDto).toList();
    }


}
