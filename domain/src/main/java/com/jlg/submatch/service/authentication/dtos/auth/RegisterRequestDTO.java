package com.jlg.submatch.service.authentication.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
