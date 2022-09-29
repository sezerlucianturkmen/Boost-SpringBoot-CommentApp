package com.bilgeadam.commentapp.mapper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCommentCreateRequestDto {
    private  String comment;
    private Long productId;
    private Long userId;
}
