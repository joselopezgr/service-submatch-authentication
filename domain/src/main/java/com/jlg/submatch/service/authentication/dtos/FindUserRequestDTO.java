package com.jlg.submatch.service.authentication.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class FindUserRequestDTO<T> {
    private String email;
    private String username;
//    private String password;
}
