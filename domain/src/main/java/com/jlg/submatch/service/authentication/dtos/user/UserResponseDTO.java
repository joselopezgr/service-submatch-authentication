package com.jlg.submatch.service.authentication.dtos.user;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponseDTO {
    @NotNull()
    private String id;

    @NotNull()
    private String name;

    @NotNull()
    private String email;

    private String phone;

    private String address;

    @NotNull()
    private String role;
}
