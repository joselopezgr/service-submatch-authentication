package com.jlg.submatch.service.authentication.dtos.user;

public record UserRecord(
        String id,
        String password,
        String email,
        String firstName,
        String lastName,
        String phone,
        String address,
        String role
) {
}
