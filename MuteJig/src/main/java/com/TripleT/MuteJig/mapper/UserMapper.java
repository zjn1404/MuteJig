package com.TripleT.MuteJig.mapper;

import com.TripleT.MuteJig.dto.request.user.UserCreationRequest;
import com.TripleT.MuteJig.dto.request.user.UserUpdateRequest;
import com.TripleT.MuteJig.dto.response.UserResponse;
import com.TripleT.MuteJig.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}
