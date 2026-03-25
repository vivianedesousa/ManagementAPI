package com.multirestaurant.managementapi.application.mapper.dto;
import com.multirestaurant.managementapi.application.dto.user.UserResponseDTO;
import com.multirestaurant.managementapi.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapperDTO {
    public UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.identity(),
                user.name(),
                user.email(),
                user.userType().name()
        );
    }
}
