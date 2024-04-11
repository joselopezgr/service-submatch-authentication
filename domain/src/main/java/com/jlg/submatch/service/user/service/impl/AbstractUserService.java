package com.jlg.submatch.service.user.service.impl;

import com.jlg.submatch.service.user.exception.UserException;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.service.UserService;
import com.jlg.submatch.service.user.strategy.UserStrategy;

import java.util.List;
import java.util.Optional;

public abstract class AbstractUserService implements UserService {

    private final List<UserStrategy> strategies;

    protected AbstractUserService(List<UserStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public User create(User user) {
        var handler = strategies.stream()
                .map(strategy -> strategy.createUserHandler(user))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new UserException("Handler not found"));
        return handler.create(user);
    }

    @Override
    public User read(String id) {
        var handler = strategies.stream()
                .map(UserStrategy::readUserHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new UserException("Handler not found"));
        return handler.read(id).orElseThrow(() -> new UserException("User not found"));
    }

    @Override
    public User update(User user) {
        var handler = strategies.stream()
                .map(UserStrategy::updateUserHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new UserException("Handler not found"));
        return handler.update(user).orElseThrow(() -> new UserException("User not found"));
    }

    @Override
    public User delete(String id) {
        var handler = strategies.stream()
                .map(UserStrategy::deleteUserHandler)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new UserException("Handler not found"));
        return handler.delete(id).orElseThrow(() -> new UserException("User not found"));
    }
}
