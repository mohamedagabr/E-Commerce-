package com.gabr.e_commerce.dto;

import com.gabr.e_commerce.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    @NotBlank(message = "Category name cannot be empty")
    private String categoryName;
    private Set<Product> products ;
}
