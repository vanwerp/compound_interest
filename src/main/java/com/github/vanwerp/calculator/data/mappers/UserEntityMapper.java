package com.github.vanwerp.calculator.data.mappers;

import com.github.vanwerp.calculator.core.models.User;
import com.github.vanwerp.calculator.data.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface UserEntityMapper {

    UserEntity toEntity(User user);
    User toModel(UserEntity user);

}
