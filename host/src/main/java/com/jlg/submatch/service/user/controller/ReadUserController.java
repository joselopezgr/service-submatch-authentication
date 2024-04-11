package com.jlg.submatch.service.user.controller;

import com.jlg.submatch.service.user.dto.UserResponseDTO;
import com.jlg.submatch.service.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/user/{id}")
public class ReadUserController extends AbstractUserController {

    final UserService userService;

    public ReadUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO read(@PathVariable String id) {
        var result = userService.read(id);
        return Optional.ofNullable(result)
                .map(this::convertToResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }
}