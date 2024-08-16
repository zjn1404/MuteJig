package com.TripleT.MuteJig.dto.response;

import java.util.Set;

import com.TripleT.MuteJig.entity.Permission;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {

    String name;

    String description;

    Set<Permission> permissions;
}
