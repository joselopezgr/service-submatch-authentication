package com.jlg.submatch.service.authentication.service.user;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;

public interface UserDomainService {
    UserRecord findUser(String id, FindUserRequestDTO<UserRecord> userData);
}
