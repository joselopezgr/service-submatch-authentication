package com.jlg.submatch.service.authentication.service.impl;

import com.jlg.submatch.service.authentication.strategy.AuthenticationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DefaultAuthenticationService extends AbstractAuthenticationService {
    public DefaultAuthenticationService(List<AuthenticationStrategy> strategies) {
    super(strategies);
    }
}