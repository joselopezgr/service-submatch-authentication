package com.jlg.submatch.service.authentication.controller;

import com.jlg.submatch.service.authentication.service.user.UserDomainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/sign-in")
public class SignInUserController {

    final UserDomainService authService;

    public SignInUserController(UserDomainService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String signIn() {
        return "Sign in";
    }
}