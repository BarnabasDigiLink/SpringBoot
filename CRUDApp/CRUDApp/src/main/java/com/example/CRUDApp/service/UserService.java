package com.example.crudapp.service;

import com.example.crudapp.dao.UserRepository;
import com.example.crudapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    //create a user
    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    //create multiple users
    public List<User> createUsers(List<User> users) {

        return userRepository.saveAll(users);
    }

    //get user-byId
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    //get users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //update user
    public User updateUser(User user){
        User oldUser = null;
        Optional<User> optionaluser = userRepository.findById(user.getId());
        /*  check user presence
         */
        if(optionaluser.isPresent()){
            oldUser = optionaluser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            oldUser.setPosition(user.getPosition());
            oldUser.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(oldUser);
        }else {
            return new User();
        }
        return oldUser;
    }
    // delete user
    public String deleteUserById(int id){
        userRepository.deleteById(id);
        return "User is deleted successfully";
    }
}
