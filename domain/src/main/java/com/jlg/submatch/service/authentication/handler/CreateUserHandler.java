package com.jlg.submatch.service.authentication.handler;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;

import java.util.Optional;

public interface CreateUserHandler {
    Optional<UserRecord> createUser(RegisterRequestDTO createUserRequestDTO);
}
