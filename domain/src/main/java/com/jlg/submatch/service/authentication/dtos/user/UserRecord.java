package com.jlg.submatch.service.authentication.dtos.user;

import java.util.List;

public record UserRecord(
        String id,
        String password,
        String email,
        String firstName,
        String lastName,
        String phone,
        String address,
        List<String> role
) {
}
