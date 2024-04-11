package com.jlg.submatch.service.user.service.impl;

import com.jlg.submatch.service.user.strategy.UserStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class DefaultUserService extends AbstractUserService {
    public DefaultUserService(List<UserStrategy> strategies) {
    super(strategies);
    }
}