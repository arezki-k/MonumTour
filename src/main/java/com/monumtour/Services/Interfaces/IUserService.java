package com.monumtour.Services.Interfaces;

import com.monumtour.DTO.UserRegistrationDto;
import com.monumtour.Model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
