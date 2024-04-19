package com.jlg.submatch.service.authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}