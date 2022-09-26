package com.bilgeadam.commentapp.exception;


import lombok.Getter;

@Getter
public class CommentAppManagerException extends RuntimeException{

    private final ErrorType errorType;

    public CommentAppManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CommentAppManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }

}