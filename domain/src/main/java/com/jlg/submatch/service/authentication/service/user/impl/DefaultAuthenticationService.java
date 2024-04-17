package com.jlg.submatch.service.authentication.service.user.impl;

import com.jlg.submatch.service.authentication.strategy.UserDomainStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DefaultAuthenticationService extends AbstractAuthenticationService {
    public DefaultAuthenticationService(List<UserDomainStrategy> strategies) {
    super(strategies);
    }
}