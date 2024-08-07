package com.TripleT.MuteJig.service.user;

import com.TripleT.MuteJig.dto.request.user.UserCreationRequest;
import com.TripleT.MuteJig.dto.request.user.UserUpdateRequest;
import com.TripleT.MuteJig.dto.response.UserResponse;

public interface UserService {

    UserResponse create(UserCreationRequest request);

    UserResponse updateById(String id, UserUpdateRequest request);

    UserResponse findById(String id);

    void deleteById(String id);

}
