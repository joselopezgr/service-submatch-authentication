package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.model.UserEntity;
import com.jlg.submatch.service.user.model.User;

abstract class AbstractMongoDBUserHandler {

    UserEntity toDBEntity(User user){
        return new UserEntity(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getAddress(),
                user.getRole()
        );
    }

    User toDomainEntity(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .phone(userEntity.getPhone())
                .address(userEntity.getAddress())
                .role(userEntity.getRole())
                .build();
    }
}
