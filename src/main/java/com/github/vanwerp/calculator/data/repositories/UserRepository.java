package com.github.vanwerp.calculator.data.repositories;

import com.github.vanwerp.calculator.core.models.User;
import com.github.vanwerp.calculator.data.entities.UserEntity;
import com.github.vanwerp.calculator.data.mappers.UserEntityMapper;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    @Inject
    private UserEntityMapper mapper;

    @Transactional
    public User saveUser(User user) {
        UserEntity entity = mapper.toEntity(user);
        persist(entity);
        return mapper.toModel(entity);
    }

    public User findUserByUsername(String username){
        return mapper.toModel(find("username",username).firstResult());
    }


}
