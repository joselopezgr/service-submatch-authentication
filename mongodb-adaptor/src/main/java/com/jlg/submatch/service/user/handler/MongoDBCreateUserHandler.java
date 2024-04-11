package com.jlg.submatch.service.user.handler;

import com.jlg.submatch.service.user.repository.UserRepository;
import com.jlg.submatch.service.user.exception.MongoDBExceptionHandler;
import com.jlg.submatch.service.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class MongoDBCreateUserHandler extends AbstractMongoDBUserHandler implements CreateUserHandler {

    private final UserRepository userRepository;

    public MongoDBCreateUserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @MongoDBExceptionHandler(message = "User creation failed")
    public User create(User user) {
        var entity = this.toDBEntity(user);

        var result = userRepository.save(entity);
        user.setId(result.getId());

        return user;
    }
}
