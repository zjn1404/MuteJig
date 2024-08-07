package com.TripleT.MuteJig.controller;

import com.TripleT.MuteJig.dto.request.user.UserCreationRequest;
import com.TripleT.MuteJig.dto.response.ApiResponse;
import com.TripleT.MuteJig.dto.response.UserResponse;
import com.TripleT.MuteJig.service.user.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @Value("${code.success}")
    @NonFinal
    static int SUCCESS_CODE;

    @PostMapping
    public ApiResponse<UserResponse> create(@RequestBody UserCreationRequest request) {

        UserResponse userResponse = userService.create(request);

        return ApiResponse.<UserResponse>builder()
                .code(SUCCESS_CODE)
                .result(userResponse)
                .build();
    }

}
