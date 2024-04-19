package com.jlg.submatch.service.authentication.handlers;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceFindUserHandler implements FindUserHandler {

    private final UserService userService;

    public UserServiceFindUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<UserRecord> findUser(AuthenticationRequestDTO userData) {
        return this.userService.findUser(userData);
    }
}
