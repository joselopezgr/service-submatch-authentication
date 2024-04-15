package com.jlg.submatch.service.authentication.handler;

import com.jlg.submatch.service.authentication.model.UserRecord;

public interface SignInUserHandler {
    UserRecord signIn(
            String username,
            String password
    );
}
