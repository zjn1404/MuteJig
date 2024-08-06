package com.TripleT.MuteJig.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppException extends RuntimeException{

    ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.message);
        this.errorCode = errorCode;
    }

}
