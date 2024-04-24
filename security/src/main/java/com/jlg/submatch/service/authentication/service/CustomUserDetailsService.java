package com.jlg.submatch.service.authentication.service;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserRecord user = userService.findUserByEmail(username).orElseThrow();
        List<SimpleGrantedAuthority> authorities = user.role().stream()
                .map(SimpleGrantedAuthority::new)
                .toList();
        return new User(user.email(), user.password(), authorities);
    }

}
