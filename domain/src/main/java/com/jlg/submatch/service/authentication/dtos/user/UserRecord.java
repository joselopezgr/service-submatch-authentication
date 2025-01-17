package com.jlg.submatch.service.authentication.dtos.user;

import java.util.List;

public record UserRecord(
        String id,
        String email,
        String password,
        String firstName,
        String lastName,
        String phone,
        String address,
        UserRole role
) {
}
