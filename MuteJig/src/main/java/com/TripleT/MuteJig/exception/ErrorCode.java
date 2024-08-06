package com.TripleT.MuteJig.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {
    // Undefined error
    UNCATEGORIZED_EXCEPTION(9999, HttpStatus.INTERNAL_SERVER_ERROR, "Uncategorized Error"),

    // Developer error
    // Used when having type like: PASWORD_INVALID
    INVALID_KEY(1001, HttpStatus.INTERNAL_SERVER_ERROR, "Uncategorized error"),

    // Client error
    // Input error
    USERNAME_INVALID(2001, HttpStatus.BAD_REQUEST, "Username must be at least {min} characters"),
    PASSWORD_INVALID(2002, HttpStatus.BAD_REQUEST, "Password must be at least {min} characters"),
    // Existed error
    USER_EXISTED(2003, HttpStatus.BAD_REQUEST, "User Existed"),
    ROLE_EXISTED(2004, HttpStatus.BAD_REQUEST, "Role Existed"),
    PERMISSION_EXISTED(2005, HttpStatus.BAD_REQUEST, "Permission Existed"),
    SONG_EXISTED(2006, HttpStatus.BAD_REQUEST, "Song Existed"),
    SINGER_EXISTED(2007, HttpStatus.BAD_REQUEST, "Singer Existed"),
    PLAYLIST_EXISTED(2008, HttpStatus.BAD_REQUEST, "Playlist Existed"),
    USER_DETAIL_EXISTED(2009, HttpStatus.BAD_REQUEST, "User Detail Existed"),
    // Not found error
    USER_NOT_EXISTED(5001, HttpStatus.NOT_FOUND, "User Not Existed"),
    ROLE_NOT_EXISTED(5002, HttpStatus.NOT_FOUND, "Role Not Existed"),
    PERMISSION_NOT_EXISTED(5003, HttpStatus.NOT_FOUND, "Permission Not Existed"),
    SONG_NOT_EXISTED(5004, HttpStatus.NOT_FOUND, "Song Not Existed"),
    SINGER_NOT_EXISTED(5005, HttpStatus.NOT_FOUND, "Singer Not Existed"),
    PLAYLIST_NOT_EXISTED(5006, HttpStatus.NOT_FOUND, "Playlist Not Existed"),
    USER_DETAIL_NOT_EXISTED(5007, HttpStatus.NOT_FOUND, "User Detail Not Existed"),
    // Unauthenticated error
    AUTHENTICATION_FAILED(3001, HttpStatus.UNAUTHORIZED, "Authentication Failed"),
    INVALID_TOKEN(3002, HttpStatus.UNAUTHORIZED, "Invalid Token"),
    // Unauthorized error
    UNAUTHORIZED(4001, HttpStatus.FORBIDDEN, "Don't have permission"),
    ;

    final int code;

    final HttpStatus httpStatus;

    final String message;
}
