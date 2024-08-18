package com.TripleT.MuteJig.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    int code;

    String message;

    T result;

}
