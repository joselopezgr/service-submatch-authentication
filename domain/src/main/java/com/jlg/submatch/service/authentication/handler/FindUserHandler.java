package com.jlg.submatch.service.authentication.handler;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;

public interface FindUserHandler {
    UserRecord findUser(String id, FindUserRequestDTO<UserRecord> userData);
}
