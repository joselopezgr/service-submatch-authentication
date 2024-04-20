package com.jlg.submatch.service.authentication.handler;

import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;

import java.util.Optional;

public interface FindUserHandler {
    Optional<UserRecord> findUserByEmail(String email);
}
