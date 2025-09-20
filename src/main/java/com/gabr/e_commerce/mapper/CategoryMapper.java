package com.gabr.e_commerce.mapper;

import com.gabr.e_commerce.dto.CategoryDto;
import com.gabr.e_commerce.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  CategoryDto toDto(Category category);
  Category toEntity(CategoryDto categoryDto);
  List<CategoryDto> toDtoList(List<Category> categoryList);
  List<Category> toEntityList(List<CategoryDto> categoryDtoList);

}
