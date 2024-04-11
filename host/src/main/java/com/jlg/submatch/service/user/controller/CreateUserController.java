package com.jlg.submatch.service.user.controller;

import com.jlg.submatch.service.user.dto.UserResponseDTO;
import com.jlg.submatch.service.user.dto.UserRequestDTO;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//@Validated
public class CreateUserController extends AbstractUserController {

    final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO create(@RequestBody @Valid UserRequestDTO requestBody) {
        User user = this.convertToDomainEntity(requestBody);
        var service = userService.create(user);

        return this.convertToResponseDTO(service);
    }
}
