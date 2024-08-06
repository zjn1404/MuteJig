package com.TripleT.MuteJig.dto.response;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.Builder;

import java.sql.Date;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailResponse {

    String firstName;

    String lastName;

    String phoneNumber;

    Date dob;

}
