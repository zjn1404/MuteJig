package com.TripleT.MuteJig.mapper;

import com.TripleT.MuteJig.dto.request.UserDetailRequest;
import com.TripleT.MuteJig.dto.response.UserDetailResponse;
import com.TripleT.MuteJig.entity.UserDetail;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
        //, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserDetailMapper {
    UserDetail toUserDetail(UserDetailRequest userDetailRequest);
    UserDetailResponse toUserDetailResponse(UserDetail userDetail);
}
