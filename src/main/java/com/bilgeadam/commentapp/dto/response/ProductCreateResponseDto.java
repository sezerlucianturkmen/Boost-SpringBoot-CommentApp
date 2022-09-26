package com.bilgeadam.commentapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateResponseDto {
    String name;
    double price;
    LocalDate expirationDate;
}
