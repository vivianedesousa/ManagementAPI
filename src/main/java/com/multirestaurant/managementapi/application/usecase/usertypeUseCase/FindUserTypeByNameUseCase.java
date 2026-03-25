package com.multirestaurant.managementapi.application.usecase.usertypeUseCase;
import com.multirestaurant.managementapi.domain.gateway.UserTypeGateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import com.multirestaurant.managementapi.domain.exception.usertype.UserTypeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service

public class FindUserTypeByNameUseCase {
    private final UserTypeGateway gateway;
    public FindUserTypeByNameUseCase(UserTypeGateway gateway) {
        this.gateway = gateway;
    }
      // sso vai ser útil no
     //cadastro de usuário
      // validação de dono de restaurante
    public UserType execute(String name) {
        Optional<UserType> optional = gateway.findByName(name);
        if (optional.isEmpty()) {
            throw new UserTypeNotFoundException("User type not found");
        }
        return optional.get();
    }   }