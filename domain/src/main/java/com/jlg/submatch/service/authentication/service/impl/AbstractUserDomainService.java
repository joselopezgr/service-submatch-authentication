package com.jlg.submatch.service.authentication.service.impl;


import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.exception.AuthenticationException;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.service.UserDomainService;
import com.jlg.submatch.service.authentication.strategy.UserDomainStrategy;

import java.util.List;
import java.util.Optional;

public abstract class AbstractUserDomainService implements UserDomainService {

    private final List<UserDomainStrategy> strategies;

    protected AbstractUserDomainService(List<UserDomainStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public Optional<UserRecord> findUser(AuthenticationRequestDTO userData) {
        var handler = strategies.stream()
                .map(strategy -> strategy.findUserHandler(userData.getUsername()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new AuthenticationException("Handler not found"));
        return handler.findUserByEmail(userData.getUsername());
    }

    @Override
    public Optional<UserRecord> createUser(RegisterRequestDTO userData) {
        var handler = strategies.stream()
                .map(strategy -> strategy.createUserHandler(userData))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new AuthenticationException("Handler not found"));
        return handler.createUser(userData);
    }
    AuthenticationRequestDTO convertToFindUserRequestDTO(String username) {
        AuthenticationRequestDTO authenticationRequestDTO = new AuthenticationRequestDTO();
        authenticationRequestDTO.setUsername(username);
        return authenticationRequestDTO;
    }
}
