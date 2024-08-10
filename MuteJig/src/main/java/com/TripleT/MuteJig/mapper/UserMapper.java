package com.TripleT.MuteJig.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.TripleT.MuteJig.dto.request.user.UserCreationRequest;
import com.TripleT.MuteJig.dto.request.user.UserUpdateRequest;
import com.TripleT.MuteJig.dto.response.UserResponse;
import com.TripleT.MuteJig.entity.User;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreationRequest request);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}
