package com.example.ewalletback.mapper;

import com.example.ewalletback.dto.request.UserRequestDto;
import com.example.ewalletback.dto.response.UserResponseDto;
import com.example.ewalletback.models.Users;

public final class UserMapper {

    private UserMapper() {
    }

    public static Users toEntity(UserRequestDto dto) {
        Users user = new Users();
        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setStatut(dto.getStatut());
        return user;
    }

    public static void updateEntity(Users user, UserRequestDto dto) {
        user.setNom(dto.getNom());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        if (dto.getStatut() != null) {
            user.setStatut(dto.getStatut());
        }
    }

    public static UserResponseDto toDto(Users user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setDateinscription(user.getDateinscription());
        dto.setStatut(user.getStatut());
        if (user.getWallet() != null) {
            dto.setWalletId(user.getWallet().getId());
        }
        return dto;
    }
}
