package com.jlg.submatch.service.authentication.controller;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;
import com.jlg.submatch.service.authentication.service.user.UserDomainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/users/find-user")
public class FindUserController {
    private final UserDomainService userService;

    public FindUserController(UserDomainService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserRecord findUser(@RequestBody FindUserRequestDTO<UserRecord> userRequest, @RequestParam String id) {
        return userService.findUser(id, userRequest);
    }
}
