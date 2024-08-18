package com.TripleT.MuteJig.service.permission;


import com.TripleT.MuteJig.dto.request.PermissionRequest;
import com.TripleT.MuteJig.dto.response.PermissionResponse;
import com.TripleT.MuteJig.entity.Permission;
import com.TripleT.MuteJig.exception.AppException;
import com.TripleT.MuteJig.exception.ErrorCode;
import com.TripleT.MuteJig.mapper.PermissionMapper;
import com.TripleT.MuteJig.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest permissionRequest) {
        if(permissionRepository.existsById(permissionRequest.getName()))
            throw new AppException(ErrorCode.PERMISSION_EXISTED);

        Permission permission = permissionMapper.toPermission(permissionRequest);

        permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll(){
        return permissionRepository.findAll().stream()
                .map(permissionMapper::toPermissionResponse)
                .toList();
    }

    @Override
    public void deleteById(String id){
        if(!permissionRepository.existsById(id))
            throw new AppException(ErrorCode.PERMISSION_NOT_EXISTED);

        permissionRepository.deleteById(id);
    }

}
