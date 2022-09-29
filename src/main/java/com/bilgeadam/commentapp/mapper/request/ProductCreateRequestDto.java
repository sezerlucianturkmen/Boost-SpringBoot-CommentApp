package com.bilgeadam.commentapp.mapper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCreateRequestDto {
    String name;
    double price;
    String expirationDate;
}
