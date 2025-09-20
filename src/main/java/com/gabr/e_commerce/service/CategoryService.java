package com.gabr.e_commerce.service;

import com.gabr.e_commerce.dto.CategoryDto;
import com.gabr.e_commerce.mapper.CategoryMapper;
import com.gabr.e_commerce.model.Category;
import com.gabr.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
   private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category save = categoryRepository.save(category);
        return categoryMapper.toDto(save);
    }
    public List<CategoryDto> getAllCategories() {
        List<Category> list = categoryRepository.findAll();
        return categoryMapper.toDtoList(list);
    }

}
