package com.jlg.submatch.service.authentication.strategy;

import com.jlg.submatch.service.authentication.handler.SignInUserHandler;
import com.jlg.submatch.service.authentication.handler.SignUpUserHandler;
import com.jlg.submatch.service.authentication.model.UserRecord;

import java.util.Optional;

public interface AuthenticationStrategy {

    Optional<SignUpUserHandler> signUpUserHandler(UserRecord userRecord);
    Optional<SignInUserHandler> signInUserHandler();
}