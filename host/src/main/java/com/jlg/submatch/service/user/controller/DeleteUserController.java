package com.jlg.submatch.service.user.controller;

import com.jlg.submatch.service.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{id}")
public class DeleteUserController {
    private final UserService userService;

    public DeleteUserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
}
