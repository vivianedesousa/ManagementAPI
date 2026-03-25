package com.multirestaurant.managementapi.application.usecase.usertypeUseCase;
import com.multirestaurant.managementapi.domain.exception.usertype.UserTypeNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.UserTypeGateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;
@Service
public class FindUserTypeByIdUseCase {
    private final UserTypeGateway gateway;
    public FindUserTypeByIdUseCase(UserTypeGateway gateway) {
      this.gateway = gateway;
    }
    public UserType execute(Long id) {
        Optional<UserType> optional = gateway.findById(id);
        if (optional.isEmpty()) {
            throw new UserTypeNotFoundException("User type not found");
        }
        return optional.get();
    }
}
