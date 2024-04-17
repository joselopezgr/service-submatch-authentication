package com.jlg.submatch.service.authentication.handlers;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFindUserHandler implements FindUserHandler {

    private final UserService userService;

    public UserServiceFindUserHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserRecord findUser(String id, FindUserRequestDTO<UserRecord> userData) {
        return this.userService.findUser(id, userData);
    }
}
