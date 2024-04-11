package com.jlg.submatch.service.user.controller;

import com.jlg.submatch.service.user.dto.UserRequestDTO;
import com.jlg.submatch.service.user.dto.UserResponseDTO;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{id}")
public class UpdateUserController extends AbstractUserController {

    final UserService userService;

    public UpdateUserController(UserService userService) { this.userService = userService; }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDTO update(@RequestBody UserRequestDTO userRequest, @PathVariable("id") String id) {
        var user = this.convertToDomainEntity(userRequest);
        user.setId(id);

        var updatedUser = userService.update(user);

        return this.convertToResponseDTO(updatedUser);
    }
}
