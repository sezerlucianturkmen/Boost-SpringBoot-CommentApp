package com.bilgeadam.commentapp.mapper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateRequestDto {

    private String name;
    private String surName;
    private String email;
    private String telephone;
    private String password;
    private LocalDate createdDate;

}
