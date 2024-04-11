package com.jlg.submatch.service.user.customRepository;

import com.jlg.submatch.service.user.model.UserEntity;
import org.bson.types.ObjectId;

public interface CustomUserRepository {

    UserEntity softDelete(ObjectId id);
}
