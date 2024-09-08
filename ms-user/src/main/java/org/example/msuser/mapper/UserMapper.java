package org.example.msuser.mapper;

import org.example.msuser.entity.UserEntity;
import org.example.msuser.model.request.UserRequest;
import org.example.msuser.model.response.UserResponse;

public enum UserMapper {
    USER_MAPPER;
    public UserEntity mapToEntity(UserRequest request){
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }
    public UserResponse mapToResponse(UserEntity entity){
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
