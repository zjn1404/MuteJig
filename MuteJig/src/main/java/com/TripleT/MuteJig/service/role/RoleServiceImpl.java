package com.TripleT.MuteJig.service.role;


import com.TripleT.MuteJig.dto.request.RoleRequest;
import com.TripleT.MuteJig.dto.response.RoleResponse;
import com.TripleT.MuteJig.entity.Permission;
import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.exception.AppException;
import com.TripleT.MuteJig.exception.ErrorCode;
import com.TripleT.MuteJig.mapper.RoleMapper;
import com.TripleT.MuteJig.repository.PermissionRepository;
import com.TripleT.MuteJig.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal =  true, level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService{

    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {

        if(roleRepository.existsById(roleRequest.getName())){
            throw new AppException(ErrorCode.ROLE_EXISTED);
        }

        Role role = roleMapper.toRole(roleRequest);

        if(roleRequest.getPermissions() != null){
            List<Permission> list = permissionRepository.findAllById(roleRequest.getPermissions());
            role.setPermissions(new HashSet<>(list));
        }
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    @Override
    public List<RoleResponse> getAll(){
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }
    @Override
    public void deleteById(String id){
        roleRepository.deleteById(id);
    }
}
