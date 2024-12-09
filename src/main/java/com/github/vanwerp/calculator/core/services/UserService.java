package com.github.vanwerp.calculator.core.services;

import com.github.vanwerp.calculator.core.models.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserService {

    User saveUser(User user);

    User getUserByUsername(String username);
}
