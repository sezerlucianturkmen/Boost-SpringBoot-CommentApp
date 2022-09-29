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
public class LikeCreateRequestDto {

    Long userId;
    Long productId;
}
