package com.jlg.submatch.service.authentication.service.user.impl;


import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.exception.AuthenticationException;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.service.user.UserDomainService;
import com.jlg.submatch.service.authentication.strategy.UserDomainStrategy;

import java.util.List;
import java.util.Optional;

public abstract class AbstractUserDomainService implements UserDomainService {

    private final List<UserDomainStrategy> strategies;

    protected AbstractUserDomainService(List<UserDomainStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public UserRecord findUser(String id, FindUserRequestDTO<UserRecord> userData) {
        var handler = strategies.stream()
                .map(strategy -> strategy.findUserHandler(id, userData))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new AuthenticationException("Handler not found"));
        return handler.findUser(id, userData);
    }
}
