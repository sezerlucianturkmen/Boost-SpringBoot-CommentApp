package com.bilgeadam.commentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFindAllResponseDto {
    private String name;
    private String surName;
    private String email;
    private  String telephone;
    @ElementCollection
    private List<Long> favProducts;



}
