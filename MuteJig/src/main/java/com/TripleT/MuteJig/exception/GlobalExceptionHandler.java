package com.TripleT.MuteJig.exception;

import com.TripleT.MuteJig.dto.response.ApiResponse;
import jakarta.validation.ConstraintViolation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String MIN_ATTRIBUTE = "min";
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception exception) {

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(ErrorCode.UNCATEGORIZED_EXCEPTION.code)
                .message(ErrorCode.UNCATEGORIZED_EXCEPTION.message)
                .build();

        return ResponseEntity.status(ErrorCode.UNCATEGORIZED_EXCEPTION.httpStatus).body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<Object>> handleAppException(AppException exception) {

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(exception.getErrorCode().code)
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(exception.getErrorCode().httpStatus).body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Object>> handleAccessDeniedException(AccessDeniedException exception) {

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(ErrorCode.UNAUTHORIZED.code)
                .message(ErrorCode.UNAUTHORIZED.message)
                .build();

        return ResponseEntity.status(ErrorCode.UNAUTHORIZED.httpStatus).body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        // If msg in @Size is type, ex "PASWORD_INVALID"
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        Map<String, Object> attributes = null;

        try {
            String errorMsg = Objects.requireNonNull(exception.getFieldError()).getDefaultMessage();
            ConstraintViolation constraintViolation =
                    exception.getAllErrors().stream().findFirst().get().unwrap(ConstraintViolation.class);

            attributes = constraintViolation.getConstraintDescriptor().getAttributes();

            errorCode = ErrorCode.valueOf(errorMsg);

        } catch (IllegalArgumentException ignored) {
        }

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .code(errorCode.code)
                .message(
                        Objects.isNull(attributes) ? errorCode.message : mapAttribute(errorCode.message, attributes)
                )
                .build();

        return ResponseEntity.status(errorCode.httpStatus).body(apiResponse);
    }

    private String mapAttribute(String message, Map<String, Object> attributes) {
        String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE));

        return message.replace("{min}", minValue);
    }
}
