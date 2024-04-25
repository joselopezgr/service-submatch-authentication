package com.jlg.submatch.service.authentication.strategy;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.handler.CreateUserHandler;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAPIStrategy implements UserDomainStrategy {
    private final FindUserHandler findUserHandler;

    private final CreateUserHandler createUserHandler;

    public UserAPIStrategy(FindUserHandler findUserHandler, CreateUserHandler createUserHandler) {
        this.findUserHandler = findUserHandler;
        this.createUserHandler = createUserHandler;
    }

    @Override
    public Optional<FindUserHandler> findUserHandler(String email) {
        return Optional.of(findUserHandler);
    }

    @Override
    public Optional<CreateUserHandler> createUserHandler(RegisterRequestDTO userData) {
        return Optional.of(createUserHandler);
    }
}

