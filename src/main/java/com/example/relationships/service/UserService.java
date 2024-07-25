package com.example.relationships.service;

import com.example.relationships.dto.UserDto;
import com.example.relationships.mapper.UserMapper;
import com.example.relationships.model.Profile;
import com.example.relationships.model.User;
import com.example.relationships.repository.ProfileRepository;
import com.example.relationships.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;

    private final UserMapper userMapper;

    @Transactional
    public UserDto createUserWithProfile(UserDto userDto) {
        Profile profile = new Profile();
        profile.setBio(userDto.getProfile().getBio());

        User user = new User();
        user.setName(userDto.getName());
        user.setProfile(profile);

        profile.setUser(user);

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }
}

