package com.jlg.submatch.service.authentication.config;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.auth.AuthenticationRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    private final UserService userService;

    public ApplicationConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            AuthenticationRequestDTO authenticationRequestDTO = convertToFindUserRequestDTO(username);
            userService.findUser(authenticationRequestDTO)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            return null;
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    AuthenticationRequestDTO convertToFindUserRequestDTO(String username) {
        AuthenticationRequestDTO authenticationRequestDTO = new AuthenticationRequestDTO();
        authenticationRequestDTO.setUsername(username);
        return authenticationRequestDTO;
    }

}
