package com.TripleT.MuteJig.controller;

import com.TripleT.MuteJig.dto.request.RoleRequest;
import com.TripleT.MuteJig.dto.response.ApiResponse;
import com.TripleT.MuteJig.dto.response.RoleResponse;
import com.TripleT.MuteJig.service.role.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    RoleService roleService;

    @NonFinal
    @Value("${code.success}")
    int success;

    @PostMapping("/")
    public ApiResponse<RoleResponse> create(@RequestBody RoleRequest roleRequest) {
        RoleResponse role = roleService.createRole(roleRequest);

        ApiResponse<RoleResponse> apiResponse = new ApiResponse<>();
            apiResponse.setCode(success);
            apiResponse.setResult(role);

        return apiResponse;
    }
    @GetMapping("/")
    public ApiResponse<List<RoleResponse>>getAll() {

        List<RoleResponse> list = roleService.getAll();

        return ApiResponse.<List<RoleResponse>>builder().code(success).result(list).build();
    }

    @DeleteMapping("/{name}")
    public ApiResponse<Void> delete(@PathVariable("name") String name) {
        roleService.deleteById(name);
        return ApiResponse.<Void>builder().code(success).
                message(String.format("Deleting role with name of %s successfully", name)).build();
    }
}
