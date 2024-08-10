package com.TripleT.MuteJig.mapper;


import com.TripleT.MuteJig.dto.request.RoleRequest;
import com.TripleT.MuteJig.dto.response.RoleResponse;
import com.TripleT.MuteJig.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
        //, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);
}
