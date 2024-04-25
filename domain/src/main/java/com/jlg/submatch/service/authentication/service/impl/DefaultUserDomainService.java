package com.jlg.submatch.service.authentication.service.impl;

import com.jlg.submatch.service.authentication.strategy.UserDomainStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DefaultUserDomainService extends AbstractUserDomainService {
    public DefaultUserDomainService(List<UserDomainStrategy> strategies) {
    super(strategies);
    }
}