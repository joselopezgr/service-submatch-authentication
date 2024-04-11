package com.jlg.submatch.service.user.strategy;

import com.jlg.submatch.service.user.handler.CreateUserHandler;
import com.jlg.submatch.service.user.handler.DeleteUserHandler;
import com.jlg.submatch.service.user.handler.ReadUserHandler;
import com.jlg.submatch.service.user.handler.UpdateUserHandler;
import com.jlg.submatch.service.user.model.User;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableMongoAuditing
public class MongoDBUserStrategy implements UserStrategy {

    private final CreateUserHandler createUserHandler;
    private final ReadUserHandler readUserHandler;
    private final UpdateUserHandler updateUserHandler;

    private final DeleteUserHandler deleteUserHandler;

    public MongoDBUserStrategy(CreateUserHandler createUserHandler, ReadUserHandler readUserHandler, UpdateUserHandler updateUserHandler, DeleteUserHandler deleteUserHandler) {
        this.createUserHandler = createUserHandler;
        this.readUserHandler = readUserHandler;
        this.updateUserHandler = updateUserHandler;
        this.deleteUserHandler = deleteUserHandler;
    }

    @Override
    public Optional<CreateUserHandler> createUserHandler(User user) {
        return Optional.of(createUserHandler);
    }

    @Override
    public Optional<ReadUserHandler> readUserHandler() {
        return Optional.of(readUserHandler);
    }

    @Override
    public Optional<UpdateUserHandler> updateUserHandler() {
        return Optional.of(updateUserHandler);
    }

    @Override
    public Optional<DeleteUserHandler> deleteUserHandler() { return Optional.of(deleteUserHandler); }

}
