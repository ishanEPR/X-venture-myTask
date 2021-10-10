package com.example.crud_app_mongodb.Service;

import com.example.crud_app_mongodb.Exception.Type.FieldRequiredException;
import com.example.crud_app_mongodb.Exception.Type.UserNotFoundException;
import com.example.crud_app_mongodb.Model.User;
import com.example.crud_app_mongodb.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User addUser(User user) {
        //test exception handling, here i can use @NotNull,@NotBlank like this.
        log.info("Inside addUser method in userRepository");
        if(user.getFirstName().isEmpty())
        {
            throw  new  FieldRequiredException("First Name Required");
        }
        return userRepository.save(user);

    }

    public List<User> getUsersDetails() {

        log.info("Inside getUsersDetails method in userRepository");
        if (userRepository.findAll().isEmpty())
        {
            throw new UserNotFoundException("User Data not available");
        }

        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(String id) {
        log.info("Inside getUserById method in userRepository");
        User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not exist with id "+id));
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> editUser(String id, User userDetails) {
        log.info("Inside editUser method in userRepository");
        User user=userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User not exist with id "+id)
        );
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());


        User updateUser=userRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }

    public ResponseEntity<String> deleteUser(String id) {
        log.info("Inside deleteUser method in userRepository");

        userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not exist new with id "+id));
        userRepository.deleteById(id);
        return ResponseEntity.ok("User Deleted Successfully");

    }
}
