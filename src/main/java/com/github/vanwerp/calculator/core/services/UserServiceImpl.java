package com.github.vanwerp.calculator.core.services;

import com.github.vanwerp.calculator.core.models.User;
import com.github.vanwerp.calculator.data.repositories.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class UserServiceImpl implements UserService{

    @Inject
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new BadRequestException("The user already exists");
        }
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole("user");
        return userRepository.saveUser(user);
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

}
