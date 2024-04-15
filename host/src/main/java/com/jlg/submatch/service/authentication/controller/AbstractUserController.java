//package com.jlg.submatch.service.user.controller;
//
//import com.jlg.submatch.service.dto.authentication.UserRequestDTO;
//import com.jlg.submatch.service.dto.authentication.UserResponseDTO;
//
//abstract class AbstractUserController {
//
//    User convertToDomainEntity(UserRequestDTO userRequestDTO) {
//        return User.builder()
//                .name(userRequestDTO.getName())
//                .email(userRequestDTO.getEmail())
//                .phone(userRequestDTO.getPhone())
//                .password(userRequestDTO.getPassword())
//                .address(userRequestDTO.getAddress())
//                .role(UserRole.valueOf(userRequestDTO.getRole()))
//                .build();
//    }
//
//    UserResponseDTO convertToResponseDTO(User user) {
//        return UserResponseDTO
//                .builder()
//                .id(user.getId())
//                .name(user.getName())
//                .email(user.getEmail())
//                .phone(user.getPhone())
//                .address(user.getAddress())
//                .role(user.getRole().toString())
//                .build();
//    }
//}