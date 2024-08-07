package com.TripleT.MuteJig.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse <T> {

    int code;

    String message;

    T result;

}
