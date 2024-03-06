 package com.example.tube.service;

import com.example.tube.exception.UserNotFoundException;
import com.example.tube.models.User;
import com.example.tube.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("can't found user by id"));
    }

    public User updateUserById(Long id, User updateUser){
        User user = getUserById(id);
        user.setFirstname(updateUser.getFirstname());
        user.setLastName(updateUser.getLastName());
        user.setPassword(updateUser.getPassword());
        return userRepo.save(user);
    }

    public void deleteUserById(Long id){
        try{
            userRepo.deleteById(id);
        }catch (EmptyResultDataAccessException ignored){}
    }
}
