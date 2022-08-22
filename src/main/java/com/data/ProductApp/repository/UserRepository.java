package com.data.ProductApp.repository;

import com.data.ProductApp.model.AuthenticationRequest;
import com.data.ProductApp.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    UserModel findByUsername(String username);
    void deleteAllById(String id);
}
