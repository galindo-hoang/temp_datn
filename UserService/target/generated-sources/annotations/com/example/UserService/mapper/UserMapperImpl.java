package com.example.UserService.mapper;

import com.example.UserService.model.dto.UserDto;
import com.example.UserService.model.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T00:33:30+0700",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto entityToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setPhoneNumber( userEntity.getPhoneNumber() );
        userDto.setUserName( userEntity.getUserName() );

        return userDto;
    }

    @Override
    public UserEntity dtoToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setPhoneNumber( userDto.getPhoneNumber() );
        userEntity.setUserName( userDto.getUserName() );

        return userEntity;
    }
}
