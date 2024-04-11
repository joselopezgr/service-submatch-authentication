package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.model.UserEntity;
import com.jlg.submatch.service.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBDeleteUserHandler extends AbstractMongoDBUserHandler implements DeleteUserHandler{

    private final UserRepository userRepository;

    public MongoDBDeleteUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "Error deleting user")
    public Optional<User> delete(String id) {
        var objectId = new ObjectId(id);
        Optional<UserEntity> dbEntity = userRepository.findByIdAndDeletedAtIsNull(objectId);

        if(dbEntity.isEmpty()) {
            return Optional.empty();
        }

        UserEntity result = userRepository.softDelete(objectId);

        return Optional.of(this.toDomainEntity(result));
    }
}
