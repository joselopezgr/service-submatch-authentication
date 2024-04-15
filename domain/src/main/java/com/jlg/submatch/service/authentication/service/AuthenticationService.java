package com.jlg.submatch.service.authentication.service;

import com.jlg.submatch.service.authentication.model.UserRecord;

public interface AuthenticationService {
    UserRecord signUp(UserRecord userRecord);
    UserRecord signIn(String username, String password);
}
