package com.jlg.submatch.service.user.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserTest {
    UUID id = UUID.randomUUID();
    String name = "name";
    String email = "email";
    String password = "password";
    String phone = "phone";
    String address = "address";
    UserRole role = UserRole.ADMIN;

    @DisplayName("Should create a User instance")
    @Test

    //ARRANGE
    void shouldCreateUserInstance() {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phone(phone)
                .address(address)
                .role(role)
                .build();

        //ASSERT
        assertAll(
                () -> assertEquals(name, user.getName()),
                () -> assertEquals(email, user.getEmail()),
                () -> assertEquals(password, user.getPassword()),
                () -> assertEquals(phone, user.getPhone()),
                () -> assertEquals(address, user.getAddress()),
                () -> assertEquals(role, user.getRole())
        );
    }

    @DisplayName("Should create a User instance with default id")
    @Test
    void shouldCreateUserInstanceWithDefaultId() {
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phone(phone)
                .address(address)
                .role(role)
                .build();

        assertNull(user.getId());
    }
}
