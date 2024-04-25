package com.jlg.submatch.service.authentication;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Optional;

public interface UserService {
    @GetExchange("/users/find-email/{email}")
    Optional<UserRecord> findUserByEmail(@PathVariable String email);

    @PostExchange("/users/create")
    Optional<UserRecord> createUser(@RequestBody RegisterRequestDTO createUserRequestDTO);
}