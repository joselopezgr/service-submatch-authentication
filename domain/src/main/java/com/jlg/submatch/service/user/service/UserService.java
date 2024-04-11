package com.jlg.submatch.service.user.service;

import com.jlg.submatch.service.user.model.User;

public interface UserService {
    User create(User user);
    User read(String id);
    User update(User user);
    User delete(String id);
}
