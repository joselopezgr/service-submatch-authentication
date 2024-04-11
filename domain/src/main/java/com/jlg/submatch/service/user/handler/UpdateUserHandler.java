package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.model.User;

import java.util.Optional;

public interface UpdateUserHandler {
    Optional<User> update(User user);
}
