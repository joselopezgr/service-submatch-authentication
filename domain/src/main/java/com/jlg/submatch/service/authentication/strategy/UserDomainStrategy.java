package com.jlg.submatch.service.authentication.strategy;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.handler.CreateUserHandler;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;

import java.util.Optional;

public interface UserDomainStrategy {

    Optional<FindUserHandler> findUserHandler(AuthenticationRequestDTO userData);

    Optional<CreateUserHandler> createUserHandler(RegisterRequestDTO userData);
}