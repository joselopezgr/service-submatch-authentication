package com.jlg.submatch.service.authentication.model;

public record UserRecord(
        String id,
        String username,
        String password,
        String email,
        String firstName,
        String lastName,
        String phone,
        String address,
        UserRoleRecord role
) {
}
