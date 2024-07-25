package com.example.relationships.mapper;

import com.example.relationships.dto.UserDto;
import com.example.relationships.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDTO = new UserDto();
        userDTO.setName(user.getName());
        userDTO.setProfile(new ProfileMapper().toDTO(user.getProfile()));

        return userDTO;
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setProfile(new ProfileMapper().toEntity(userDto.getProfile()));

        return user;
    }
}
