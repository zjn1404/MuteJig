package com.TripleT.MuteJig.dto.response;

import java.sql.Date;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailResponse {

    String firstName;

    String lastName;

    String phoneNumber;

    Date dob;
}
