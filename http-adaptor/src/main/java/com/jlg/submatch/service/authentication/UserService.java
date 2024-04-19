package com.jlg.submatch.service.authentication;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Optional;

public interface UserService {
    @PostExchange("/users/find-user")
    @Cacheable("findUserResults")
    Optional<UserRecord> findUser(@RequestBody AuthenticationRequestDTO authenticationRequestDTO);

    @PostExchange("/users/create-user")
    Optional<UserRecord> createUser(@RequestBody RegisterRequestDTO createUserRequestDTO);
}