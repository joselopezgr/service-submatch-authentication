package com.jlg.submatch.service.authentication.controller;

import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.service.UserDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth/users/find-user")
public class FindUserController {
    private final UserDomainService userService;

    public FindUserController(UserDomainService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserRecord> findUser(@RequestBody AuthenticationRequestDTO userRequest) {
        return userService.findUser(userRequest);
    }
}
