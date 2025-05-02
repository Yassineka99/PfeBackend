package com.example.process.management.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User updateUser(User user)
    {
        User currentUser = userrepo.findById(user.getId()).orElse(null);
        if(currentUser !=null)
        {
            currentUser.setEmail(user.getEmail());
            currentUser.setPassword(user.getPassword());
            currentUser.setPhone(user.getPhone());
            currentUser.setRole(user.getRole());
            return userrepo.save(currentUser);
        }
        return null ;
        
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
    
}
