package com.jlg.submatch.service.user.customRepository;

import com.jlg.submatch.service.user.model.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final MongoTemplate mongoTemplate;

    public CustomUserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public UserEntity softDelete(ObjectId id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        LocalDateTime now = LocalDateTime.now();

        UserEntity entity = mongoTemplate.findOne(query, UserEntity.class);

        assert entity != null;
        entity.setDeletedAt(now);

        return mongoTemplate.save(entity);
    }

}
