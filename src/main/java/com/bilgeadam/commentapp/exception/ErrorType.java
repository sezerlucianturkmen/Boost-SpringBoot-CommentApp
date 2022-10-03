package com.bilgeadam.commentapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(1000,"Aramakta olduğunuz kullanıcı sistemde kayıtlı değil",INTERNAL_SERVER_ERROR),
    USER_NOT_CREATED(1001,"Kullanıcı kaydedilemedi",INTERNAL_SERVER_ERROR),
    PRODUCT_NOT_FOUND(2000,"Ürün Databasede  bulunamadı",INTERNAL_SERVER_ERROR),
    PRODUCT_NOT_CREATED(2001,"Ürün kaydedilemedi",INTERNAL_SERVER_ERROR),
    LIKE_NOT_FOUND(3001,"Like bulunamadı",INTERNAL_SERVER_ERROR),
    LIKE_NOT_CREATED(3002,"Like Oluşturulamadı",INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}