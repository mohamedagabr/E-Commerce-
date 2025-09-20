package com.gabr.e_commerce.mapper;

import com.gabr.e_commerce.dto.ProductDto;
import com.gabr.e_commerce.model.Product;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper{
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);

    List<ProductDto> toDto(List<Product> products);
    List<Product> toEntity(List<ProductDto> productDtos);
}
