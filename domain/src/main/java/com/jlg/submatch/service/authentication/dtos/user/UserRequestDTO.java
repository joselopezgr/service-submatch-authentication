package com.jlg.submatch.service.authentication.dtos.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDTO {

    @NotNull()
    private String name;

    @NotNull()
    private String email;

    @NotNull()
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    private String phone;

    private String address;

    @Pattern(regexp = "^(USER|ADMIN)$")
    private String role;
}
