package com.gabr.e_commerce.mapper;

import com.gabr.e_commerce.dto.CartDto;
import com.gabr.e_commerce.model.Cart;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
    Cart toEntity(CartDto cartDto);
    List<CartDto> toDtoList(List<Cart> cartList);
    List<Cart> toEntityList(List<CartDto> cartDtoList);
}
