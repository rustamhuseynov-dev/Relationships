package com.example.relationships.mapper;

import com.example.relationships.dto.ProfileDTO;
import com.example.relationships.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public ProfileDTO toDTO(Profile profile) {
        if (profile == null) {
            return null;
        }

        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setBio(profile.getBio());

        return profileDTO;
    }

    public Profile toEntity(ProfileDTO profileDTO) {
        if (profileDTO == null) {
            return null;
        }

        Profile profile = new Profile();
        profile.setBio(profileDTO.getBio());

        return profile;
    }
}

