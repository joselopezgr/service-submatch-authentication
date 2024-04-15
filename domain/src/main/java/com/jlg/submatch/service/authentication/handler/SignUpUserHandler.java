package com.jlg.submatch.service.authentication.handler;

import com.jlg.submatch.service.authentication.model.UserRecord;

public interface SignUpUserHandler {
    UserRecord signUp(UserRecord userRecord);
}
