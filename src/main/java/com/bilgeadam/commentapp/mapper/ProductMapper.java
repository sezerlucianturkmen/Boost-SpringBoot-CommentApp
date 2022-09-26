package com.bilgeadam.commentapp.mapper;

import com.bilgeadam.commentapp.dto.response.ProductCreateResponseDto;
import com.bilgeadam.commentapp.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);


    ProductCreateResponseDto toProductCreateResponseDto(final Product product);

    Product toProduct(final  ProductCreateResponseDto productCreateResponseDto);

}