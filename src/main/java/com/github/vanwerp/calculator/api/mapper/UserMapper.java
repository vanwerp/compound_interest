package com.github.vanwerp.calculator.api.mapper;

import com.github.vanwerp.calculator.api.request.UserRequest;
import com.github.vanwerp.calculator.api.resources.UserResource;
import com.github.vanwerp.calculator.core.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface UserMapper {

    User fromRequestToModel(UserRequest request);

    UserResource toResource(User user);

}
