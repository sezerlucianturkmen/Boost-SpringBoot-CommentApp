package com.bilgeadam.commentapp.mapper;

import com.bilgeadam.commentapp.dto.response.UserCreateResponseDto;
import com.bilgeadam.commentapp.dto.response.UserFindAllResponseDto;
import com.bilgeadam.commentapp.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserCreateResponseDto toUserCreateResponseDto(final User user);

    User toUser(final  UserCreateResponseDto userCreateResponseDto);

   // UserFindAllResponseDto  toUserFindAllResponseDto (final User user);

   // User toUser(final  UserFindAllResponseDto userFindAllResponseDto);

}