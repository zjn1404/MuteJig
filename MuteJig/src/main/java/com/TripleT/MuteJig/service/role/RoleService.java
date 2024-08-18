package com.TripleT.MuteJig.service.role;

import com.TripleT.MuteJig.dto.request.RoleRequest;
import com.TripleT.MuteJig.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse createRole(RoleRequest roleRequest);
    void deleteById(String id);
    List<RoleResponse> getAll();

}
