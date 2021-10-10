package com.example.crud_app_mongodb.Repository;

import com.example.crud_app_mongodb.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

}
