package com.jlg.submatch.service.user.config;

import com.jlg.submatch.service.authentication.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Autowired
    public UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        var user = userService.findUser("1", null);

    }
}
