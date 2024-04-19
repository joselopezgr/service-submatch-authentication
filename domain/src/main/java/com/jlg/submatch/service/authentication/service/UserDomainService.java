package com.jlg.submatch.service.authentication.service;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;

import java.util.Optional;

public interface UserDomainService {
    Optional<UserRecord> findUser(AuthenticationRequestDTO userData);

    Optional<UserRecord> createUser(RegisterRequestDTO userData);
}
