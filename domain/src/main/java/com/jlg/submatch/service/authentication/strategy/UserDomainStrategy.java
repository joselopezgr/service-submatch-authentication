package com.jlg.submatch.service.authentication.strategy;

import com.jlg.submatch.service.authentication.dtos.FindUserRequestDTO;
import com.jlg.submatch.service.authentication.handler.FindUserHandler;

import java.util.Optional;

public interface UserDomainStrategy {

    Optional<FindUserHandler> findUserHandler(String id, FindUserRequestDTO userData);
}