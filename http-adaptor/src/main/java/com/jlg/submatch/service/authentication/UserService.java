package com.jlg.submatch.service.authentication;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface UserService {
    @PostExchange("/users/find-user")
    @Cacheable("findUserResults")
    UserRecord findUser(@PathVariable String id, @RequestBody FindUserRequestDTO<UserRecord> findUserRequestDTO);
}