package com.gabr.e_commerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotBlank(message = "Product name cannot be empty")
    private String productName;
    @Positive(message = "Price must be positive")
    private BigDecimal price ;
    @NotBlank(message = "Category name cannot be empty")
    private String categoryName ;
}
