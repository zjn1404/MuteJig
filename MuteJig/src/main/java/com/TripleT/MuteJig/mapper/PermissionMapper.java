package com.TripleT.MuteJig.mapper;


import com.TripleT.MuteJig.dto.request.PermissionRequest;
import com.TripleT.MuteJig.dto.response.PermissionResponse;
import com.TripleT.MuteJig.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
       //, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}
