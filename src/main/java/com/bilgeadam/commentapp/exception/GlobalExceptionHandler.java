package com.bilgeadam.commentapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok("Beklenmeyen bir hata oluştu: " + ex.getMessage());
    }


    @ExceptionHandler(CommentAppManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleCommentAppManagerException(CommentAppManagerException ex){
        ErrorType errorType = ex.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        /**
         * ResponseEntity.ok().build(); // 200
         */
        return new ResponseEntity<>(createError(errorType,ex),httpStatus);
    }


    private ErrorMessage createError(ErrorType errorType, Exception exception){
        System.out.println("Hata oluştu: " + exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}