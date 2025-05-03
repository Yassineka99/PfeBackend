package com.example.process.management.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.process.management.Dto.UserDto;
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
    public void deleteUser(@PathVariable Long id)
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

        @GetMapping("/get-all-by-status-id/{id}")
        public List<User> GetAllbyStatusid(@PathVariable Long id){
            return userService.getUserByRoleId(id);
        }

        @PostMapping("/uploadImage/{userId}")
        public ResponseEntity<User> uploadUserImage(@PathVariable Long userId, 
                                                @RequestParam("image") MultipartFile image) {
        User updatedUser = userService.uploadImage(userId, image);
        return updatedUser != null ?
               ResponseEntity.status(HttpStatus.OK).body(updatedUser) :
               ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        @GetMapping("/get/{id}/image")
        public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
            User user = userService.getUserByID(id).orElse(null);
            if (user == null || user.getImage() == null) return ResponseEntity.notFound().build();
        
            byte[] imageBytes = Base64.getDecoder().decode(user.getImage()); // Decode base64 string to bytes
        
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(user.getImageType()));
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        }
        @PostMapping("/update/picture")
public ResponseEntity<User> updateUserProfilePicture(@RequestBody UserDto userDto) {
    Optional<User> optionalUser = userService.getUserByID(userDto.getId());
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        user.setImage(userDto.getImage());             // base64 string
        user.setImageType(userDto.getImageType());
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


    
}
