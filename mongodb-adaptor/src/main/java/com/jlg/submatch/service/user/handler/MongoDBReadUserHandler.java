package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.model.User;
import com.jlg.submatch.service.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoDBReadUserHandler extends AbstractMongoDBUserHandler implements ReadUserHandler {

    private final UserRepository userRepository;

    public MongoDBReadUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> read(String id) {
        var objectId = new ObjectId(id);
        var entity = userRepository.findByIdAndDeletedAtIsNull(objectId);
        return entity.map(this::toDomainEntity);
    }
}
