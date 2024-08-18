package com.TripleT.MuteJig.controller;


import com.TripleT.MuteJig.dto.request.PermissionRequest;
import com.TripleT.MuteJig.dto.response.ApiResponse;
import com.TripleT.MuteJig.dto.response.PermissionResponse;
import com.TripleT.MuteJig.service.permission.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permission")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @NonFinal
    @Value("${code.success}")
    int code;

    @PostMapping("/")
    public ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest permissionRequest) {
        PermissionResponse permissionResponse = permissionService.create(permissionRequest);

        return ApiResponse.<PermissionResponse>builder()
                .code(code).message("Permission created")
                .result(permissionResponse)
                .build();

    }

    @GetMapping("/")
    public ApiResponse<List<PermissionResponse>> getAllPermissions() {
        List<PermissionResponse> list = permissionService.getAll();

        return ApiResponse.<List<PermissionResponse>>builder()
                .message("").result(list).code(code).build();
    }

    @DeleteMapping("/{name}")
    public ApiResponse<Void> deletePermission(@PathVariable String name) {
        permissionService.deleteById(name);

        return ApiResponse.<Void>builder()
                .code(0)
                .message("permission deleted")
                .build();
    }


}
