package com.jlg.submatch.service.authentication.service;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationResponseDTO;
import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authenticationRequestDTO, HttpServletResponse response) {
        var authUser = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDTO.getUsername(),
                        authenticationRequestDTO.getPassword()
                )
        );
        var user = userService.findUserByEmail(authenticationRequestDTO.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        Cookie jwtCookie = jwtService.createCookie("JWT-token", jwtToken, 60 * 60 * 24 * 7);
        response.addCookie(jwtCookie);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO register(RegisterRequestDTO registerRequestDTO, HttpServletResponse response) {
        var encodedPassword = passwordEncoder.encode(registerRequestDTO.getPassword());
        registerRequestDTO.setPassword(encodedPassword);
        var user = userService.createUser(registerRequestDTO).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        Cookie jwtCookie = jwtService.createCookie("JWT-token", jwtToken, 60 * 60 * 24 * 7);
        response.addCookie(jwtCookie);
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
