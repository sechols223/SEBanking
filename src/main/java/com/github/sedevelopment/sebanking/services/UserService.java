package com.github.sedevelopment.sebanking.services;

import com.github.sedevelopment.sebanking.models.user.User;
import com.github.sedevelopment.sebanking.web.dto.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO registrationDto);
}
