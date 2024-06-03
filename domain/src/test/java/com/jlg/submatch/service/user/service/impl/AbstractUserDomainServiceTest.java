package com.jlg.submatch.service.user.service.impl;

import com.jlg.submatch.service.authentication.dtos.auth.RegisterRequestDTO;
import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.dtos.user.UserRole;
import com.jlg.submatch.service.authentication.exception.AuthenticationException;
import com.jlg.submatch.service.authentication.handler.CreateUserHandler;
import com.jlg.submatch.service.authentication.service.impl.AbstractUserDomainService;
import com.jlg.submatch.service.authentication.strategy.UserDomainStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AbstractUserDomainServiceTest {

    @Mock
    private UserDomainStrategy strategy;

    @Mock
    private CreateUserHandler createUserHandler;

    private AbstractUserDomainService abstractUserDomainService;

    @BeforeEach
    public void setUp() {
        abstractUserDomainService = new AbstractUserDomainService(List.of(strategy)) {};
    }

    @DisplayName("Test create user handler is found")
    @Test
    public void testCreateUserHandlerIsFound() {
        String id = "id";
        UserRole role = UserRole.ADMIN;
        RegisterRequestDTO user = new RegisterRequestDTO(
                id,
                "email",
                "password",
                "name",
                "surname",
                "phone",
                "address",
                role
        );
        when(strategy.createUserHandler(user)).thenReturn(Optional.of(createUserHandler));
        when(createUserHandler.createUser(user)).thenReturn(Optional.of(new UserRecord(
                id,
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getAddress(),
                role
        )));
        abstractUserDomainService.createUser(user);
        verify(createUserHandler).createUser(user);
    }
    @DisplayName("Test create user handler is not found")
    @Test
    public void testCreateUserHandlerIsNotFound() {
        String id = "id";
        UserRole role = UserRole.ADMIN;
        RegisterRequestDTO user = new RegisterRequestDTO(
                id,
                "email",
                "password",
                "name",
                "surname",
                "phone",
                "address",
                role
        );
        when(strategy.createUserHandler(user)).thenReturn(Optional.empty());

        AuthenticationException exception = assertThrows(
                AuthenticationException.class,
                () -> abstractUserDomainService.createUser(user)
        );
        assertTrue(exception.getMessage().contains("Handler not found"));
        }
}
