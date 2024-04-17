package com.jlg.submatch.service.authentication.strategy;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAPIStrategy implements UserDomainStrategy {
    private final FindUserHandler findUserHandler;

    public UserAPIStrategy(FindUserHandler findUserHandler) {
        this.findUserHandler = findUserHandler;
    }

    @Override
    public Optional<FindUserHandler> findUserHandler(String id, FindUserRequestDTO userData) {
        return Optional.of(findUserHandler);
    }
}

