package com.TripleT.MuteJig.dto.response;

import java.util.Set;

import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.entity.UserDetail;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;

    String username;

    String password;

    String email;

    Set<Role> roles;

    UserDetail userDetail;
}
