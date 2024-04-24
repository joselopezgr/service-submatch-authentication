package com.jlg.submatch.service.user.model;

import com.jlg.submatch.service.authentication.dtos.user.UserRecord;
import com.jlg.submatch.service.authentication.dtos.user.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserTest {
    String id = "1111111";
    String firstName = "name";
    String lastName = "name";
    String email = "email";
    String password = "password";
    String phone = "phone";
    String address = "address";
    UserRole role = UserRole.ADMIN;

    @DisplayName("Should create a User instance")
    @Test

    //ARRANGE
    void shouldCreateUserInstance() {
        UserRecord user = new UserRecord(id, firstName, lastName, email, password, phone, address, role);

        //ASSERT
        assertAll(
                () -> assertEquals(firstName, user.firstName()),
                () -> assertEquals(lastName, user.lastName()),
                () -> assertEquals(email, user.email()),
                () -> assertEquals(password, user.password()),
                () -> assertEquals(phone, user.phone()),
                () -> assertEquals(address, user.address()),
                () -> assertEquals(role, user.role())
        );
    }

    @DisplayName("Should create a User instance with default id")
    @Test
    void shouldCreateUserInstanceWithDefaultId() {
        UserRecord user = new UserRecord(id, firstName, lastName, email, password, phone, address, role);


        assertNull(user.id());
    }
}
