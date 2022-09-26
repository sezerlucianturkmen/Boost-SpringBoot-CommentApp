package com.bilgeadam.commentapp.mapper;

import com.bilgeadam.commentapp.dto.request.ProductCommentCreateRequestDto;
import com.bilgeadam.commentapp.repository.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentMapper {

    ProductCommentMapper INSTANCE= Mappers.getMapper(ProductCommentMapper.class);

    ProductComment toProductComment(final ProductCommentCreateRequestDto requestDto);

}