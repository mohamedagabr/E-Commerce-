package com.gabr.e_commerce.mapper;
import com.gabr.e_commerce.dto.UserDto;
import com.gabr.e_commerce.model.User;
@org.mapstruct.Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);

}
