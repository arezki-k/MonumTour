package com.monumtour.Services.Interfaces;

import com.monumtour.DTO.UserRegistrationDto;
import com.monumtour.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User getUser(String email);
    List<User> getAllUsers();
    void saveUser(User user);
    void deleteUser(String mail);
    User getUserById(Long id);
}
