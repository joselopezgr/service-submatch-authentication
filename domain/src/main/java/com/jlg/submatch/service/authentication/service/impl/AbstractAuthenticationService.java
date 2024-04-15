package com.jlg.submatch.service.authentication.service.impl;


import com.jlg.submatch.service.authentication.exception.AuthenticationException;
import com.jlg.submatch.service.authentication.model.UserRecord;
import com.jlg.submatch.service.authentication.service.AuthenticationService;
import com.jlg.submatch.service.authentication.strategy.AuthenticationStrategy;

import java.util.List;
import java.util.Optional;

public abstract class AbstractAuthenticationService implements AuthenticationService {

    private final List<AuthenticationStrategy> strategies;

    protected AbstractAuthenticationService(List<AuthenticationStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public UserRecord signIn(String username, String password) {
        var handler = strategies.stream()
                .map(strategy -> strategy.signInUserHandler())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new AuthenticationException("Handler not found"));
        return handler.signIn(username, password);
    }

    @Override
    public UserRecord signUp(UserRecord userRecord) {
        var handler = strategies.stream()
                .map(strategy -> strategy.signUpUserHandler(userRecord))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new AuthenticationException("Handler not found"));
        return handler.signUp(userRecord);
    }
}
