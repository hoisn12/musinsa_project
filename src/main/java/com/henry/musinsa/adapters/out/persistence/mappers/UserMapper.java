package com.henry.musinsa.adapters.out.persistence.mappers;

import com.henry.musinsa.adapters.out.persistence.entity.UserJPAEntity;
import com.henry.musinsa.domain.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserJPAEntity UserJPAEntity);
    List<User> toDomain(List<UserJPAEntity> UserJPAEntityList);

    UserJPAEntity toEntity(User user);
    List<UserJPAEntity> toEntity(List<User> userList);


}
