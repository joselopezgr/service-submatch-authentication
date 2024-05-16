package com.jlg.submatch.service.authentication.controller;

import com.jlg.submatch.service.authentication.JwtAuthenticationFilter;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationResponseDTO;
import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.service.AuthenticationService;
import com.jlg.submatch.service.authentication.service.JwtService;
import com.jlg.submatch.service.authentication.service.UserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;

    public AuthenticationController
            (AuthenticationService authenticationService, JwtService jwtService, JwtAuthenticationFilter jwtAuthenticationFilter, UserDetailsService userDetailsService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO registerRequestDTO, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.register(registerRequestDTO, response));
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO authRequestDTO, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.authenticate(authRequestDTO, response));
    }

    @GetMapping("/check")
    public ResponseEntity<Void> checkAuthentication(HttpServletRequest request) {
        String jwt = jwtAuthenticationFilter.getJwtFromRequest(request);
        if(jwt != null && jwtService.isTokenValid(jwt, userDetailsService.loadUserByUsername(jwtService.extractUsername(jwt)))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/payload")
    public ResponseEntity<Map<String, String>> getPayload(HttpServletRequest request) {
        String jwt = jwtAuthenticationFilter.getJwtFromRequest(request);
        if(jwt != null && jwtService.isTokenValid(jwt, userDetailsService.loadUserByUsername(jwtService.extractUsername(jwt)))) {
            Map<String, String> payload = new HashMap<>();
            payload.put("email", jwtService.extractUsername(jwt));
            payload.put("role", jwtService.extractRole(jwt));
            return ResponseEntity.ok(payload);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/signout")
    public ResponseEntity<Void> signOut(HttpServletResponse response) {
        response.addCookie(jwtService.createCookie("JWT-token", "", 0));
        return ResponseEntity.ok().build();
    }
}