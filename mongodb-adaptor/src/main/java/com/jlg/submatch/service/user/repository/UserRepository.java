package com.jlg.submatch.service.user.repository;

import com.jlg.submatch.service.user.customRepository.CustomUserRepository;
import com.jlg.submatch.service.user.model.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ListCrudRepository<UserEntity, ObjectId>, CustomUserRepository {
    Optional<UserEntity> findByIdAndDeletedAtIsNull(ObjectId id);
}
