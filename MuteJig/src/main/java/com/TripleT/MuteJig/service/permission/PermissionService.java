package com.TripleT.MuteJig.service.permission;

import com.TripleT.MuteJig.dto.request.PermissionRequest;
import com.TripleT.MuteJig.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(PermissionRequest permissionRequest);

    List<PermissionResponse> getAll();

    void deleteById(String id);
}
