package com.jlg.submatch.service.user.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;

    private final String name;

    private final String email;

    private final String password;

    private final String phone;

    private final String address;

    private final UserRole role;

    private LocalDateTime deletedAt;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;
}
