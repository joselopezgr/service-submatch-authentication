package com.jlg.submatch.service.authentication.dtos.auth;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    @NotNull()
    private String email;
    @NotNull()
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @NotNull()
    private String firstName;
    @NotNull()
    private String lastName;

    private String phone;

    private String address;

    @Pattern(regexp = "^(USER|ADMIN)$")
    private String role;
}
