package com.example.process.management.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.process.management.Model.User;
import com.example.process.management.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> CreateUser(@RequestBody User User) {
        User savedUser= userService.saveUser(User);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PostMapping("/multpile/create")
    public ResponseEntity<List<User>> CreateMultipleUser(@RequestBody List<User> Users) {
       List<User> savedUser = new ArrayList<>();

        for(User item : Users)
       {
        savedUser.add(userService.saveUser(item));
       }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @PostMapping("/update")
    public ResponseEntity <User> UpdateUser(@RequestBody User User){
        User updatedUser = userService.updateUser(User);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }
    @PostMapping("/delete")
    public void deleteUser(@RequestBody Long id)
    {
        userService.deleteUser(id);
    }
    @GetMapping("/getUserById/{id}")
    public Optional<User> getUserByID(@PathVariable Long id)
    {
        return userService.getUserByID(id);
    }
    @GetMapping("/getUserByEmail/{useremail}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String useremail)
    {
        User User = userService.findByEmail(useremail);
        if(User !=null)
        {   
           
            return ResponseEntity.status(HttpStatus.OK).body(User);
        }
        else {
           
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(User);
        }
        }
    
}
