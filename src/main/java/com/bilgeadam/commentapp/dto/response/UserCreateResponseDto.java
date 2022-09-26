package com.bilgeadam.commentapp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateResponseDto {

    private String name;
    private String surname;
    private String email;


}