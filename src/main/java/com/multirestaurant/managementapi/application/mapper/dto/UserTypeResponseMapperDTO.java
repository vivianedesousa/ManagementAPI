package com.multirestaurant.managementapi.application.mapper.dto;
import com.multirestaurant.managementapi.application.dto.usertype.UserTypeResponseDTO;
import com.multirestaurant.managementapi.domain.model.UserType;
import org.springframework.stereotype.Component;
@Component
//UserTypeResponse dt
//Converter de Domain → DTO
public class UserTypeResponseMapperDTO {
    public UserTypeResponseDTO toResponse(UserType userType) {
        return new UserTypeResponseDTO(
                userType.identity(),
                userType.name()
        );
    }
}