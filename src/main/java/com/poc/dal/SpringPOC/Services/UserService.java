package com.poc.dal.SpringPOC.Services;

import com.poc.dal.SpringPOC.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(User user) {
        return mongoTemplate.save(user);
    }

    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    public User getUserByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class);
    }

    public User updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update()
                .set("name", user.getName())
                .set("email", user.getEmail());
        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public void deleteUser(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }
}
