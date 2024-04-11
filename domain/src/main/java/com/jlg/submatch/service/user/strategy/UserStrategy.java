package com.jlg.submatch.service.user.strategy;

import com.jlg.submatch.service.user.handler.CreateUserHandler;
import com.jlg.submatch.service.user.handler.DeleteUserHandler;
import com.jlg.submatch.service.user.handler.ReadUserHandler;
import com.jlg.submatch.service.user.handler.UpdateUserHandler;
import com.jlg.submatch.service.user.model.User;

import java.util.Optional;

public interface UserStrategy {
    Optional<CreateUserHandler> createUserHandler(User user);

    Optional<ReadUserHandler> readUserHandler();

    Optional<UpdateUserHandler> updateUserHandler();

    Optional<DeleteUserHandler> deleteUserHandler();
}
