package com.jlg.submatch.service.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Builder
@Data
public class User {
    @Builder.Default
    private String id = null;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String phone;

    private String address;

    private UserRole role;
}

