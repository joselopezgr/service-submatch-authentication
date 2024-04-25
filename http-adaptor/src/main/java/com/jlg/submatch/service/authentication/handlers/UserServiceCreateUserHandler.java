package com.jlg.submatch.service.authentication.handlers;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.handler.CreateUserHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceCreateUserHandler implements CreateUserHandler {
    private final UserService userService;

    public UserServiceCreateUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<UserRecord> createUser(RegisterRequestDTO userData) {
        return this.userService.createUser(userData);
    }
}
