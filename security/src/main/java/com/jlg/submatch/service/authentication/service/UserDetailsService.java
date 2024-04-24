package com.jlg.submatch.service.authentication.service;

import com.jlg.submatch.service.authentication.UserService;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserService userService;

    public UserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserRecord user = userService.findUserByEmail(username).orElseThrow();
        return new User(user.email(), user.password(), new ArrayList<>());
    }

}
