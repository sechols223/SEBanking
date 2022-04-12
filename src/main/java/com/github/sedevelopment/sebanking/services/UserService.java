package com.github.sedevelopment.sebanking.services;

import com.github.sedevelopment.sebanking.repositories.UserRepository;
import com.github.sedevelopment.sebanking.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User getById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User with id: " + id +
                                        " not found!");
        }
        return user;
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
