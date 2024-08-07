package com.TripleT.MuteJig.service.user;

import com.TripleT.MuteJig.dto.request.user.UserCreationRequest;
import com.TripleT.MuteJig.dto.request.user.UserUpdateRequest;
import com.TripleT.MuteJig.dto.response.UserResponse;
import com.TripleT.MuteJig.entity.Role;
import com.TripleT.MuteJig.exception.AppException;
import com.TripleT.MuteJig.exception.ErrorCode;
import com.TripleT.MuteJig.repository.RoleRepository;
import com.TripleT.MuteJig.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImp implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Override
    public UserResponse create(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        List<Role> role = roleRepository.findAllById(request.getRoles());

        return null;
    }

    @Override
    public UserResponse updateById(String id, UserUpdateRequest request) {
        return null;
    }

    @Override
    public UserResponse findById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
