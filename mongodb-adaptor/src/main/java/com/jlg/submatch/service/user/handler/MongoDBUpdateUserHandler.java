package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.model.UserEntity;
import com.jlg.submatch.service.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBUpdateUserHandler extends AbstractMongoDBUserHandler implements UpdateUserHandler {

    private final UserRepository userRepository;

    public MongoDBUpdateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "User update failed")
    public Optional<User> update(User updatedUser) {
        var objectId = new ObjectId(updatedUser.getId());
        Optional<UserEntity> dbEntity = this.userRepository.findById(objectId);
        if(dbEntity.isEmpty()) {
            return Optional.empty();
        }

        UserEntity entityToSave = this.toDBEntity(updatedUser);
        entityToSave.setId(updatedUser.getId());
        userRepository.save(entityToSave);
        return Optional.of(updatedUser);
    }
}
