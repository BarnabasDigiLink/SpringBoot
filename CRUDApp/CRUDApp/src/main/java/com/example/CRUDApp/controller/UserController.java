package com.example.CRUDApp.controller;

import com.example.CRUDApp.entity.User;
import com.example.CRUDApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    /*
     * post methods to handle creating a user(s)
     * */
    private final UserService userService;
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //method for list of users
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return userService.createUsers(users);
    }

    // method for getting users by id
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    //method for getting all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    /*
    * update user methods
    * */
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    /*
     * delete user methods
     * */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUserById(id);
    }
}
