package com.jlg.submatch.service.user.controller;

import com.jlg.submatch.service.user.dto.UserRequestDTO;
import com.jlg.submatch.service.user.dto.UserResponseDTO;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.model.UserRole;

import java.util.Optional;
import java.util.UUID;

abstract class AbstractUserController {

    User convertToDomainEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .phone(userRequestDTO.getPhone())
                .password(userRequestDTO.getPassword())
                .address(userRequestDTO.getAddress())
                .role(UserRole.valueOf(userRequestDTO.getRole()))
                .build();
    }

    UserResponseDTO convertToResponseDTO(User user) {
        return UserResponseDTO
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole().toString())
                .build();
    }
}