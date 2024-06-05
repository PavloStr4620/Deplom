package com.example.deplom.mappers;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.models.User;
import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User toModel(UserDTO userDTO);
    UserDTO toDTO(User user);
}
