package com.example.process.management.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.process.management.Model.User;
import com.example.process.management.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepo ;

    public User saveUser(User user)
    {
        user.setCreatedAt(new Date());
        return userrepo.save(user);
    }
    public Optional<User> getUserByID(Long id)
    {
         return userrepo.findById(id);
    }
    public User updateUser(User user) {
        User current = userrepo.findById(user.getId()).orElseThrow();
        if (user.getEmail() != null)    current.setEmail(user.getEmail());
        if (user.getPassword() != null) current.setPassword(user.getPassword());
        if (user.getPhone() != null)    current.setPhone(user.getPhone());
        if (user.getRole() != 0)        current.setRole(user.getRole());
        if (user.getImage() != null) {
          current.setImage(user.getImage());
          current.setImageType(user.getImageType());
        }
        return userrepo.save(current);
    }
    
    public void deleteUser(Long id)
    {
        User current = userrepo.findById(id).orElse(null);
        if ( current != null)
        {
            userrepo.delete(current);
        }
    }
    public User findByEmail(String email)
    {
        return userrepo.findByEmail(email);
    }

    public List<User> getUserByRoleId(Long id)
    {
       return userrepo.findAllByRoleID(id);
    }

    public User uploadImage(Long userId, MultipartFile image) {
        User user = userrepo.findById(userId).orElse(null);
        if (user != null && image != null && !image.isEmpty()) {
            try {
                // Convert byte[] to base64 string
                String base64Image = Base64.getEncoder().encodeToString(image.getBytes());
                user.setImage(base64Image);
                user.setImageType(image.getContentType());
                return userrepo.save(user);  // Save user with base64 image string
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    
}
