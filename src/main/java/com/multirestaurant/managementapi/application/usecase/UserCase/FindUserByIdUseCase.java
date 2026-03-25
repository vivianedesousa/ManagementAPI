package com.multirestaurant.managementapi.application.usecase.UserCase;
import com.multirestaurant.managementapi.domain.exception.user.UserNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FindUserByIdUseCase {
    private final UserGateway userGateway;

    public FindUserByIdUseCase(UserGateway userGateway) {
    this.userGateway = userGateway;
    }
    public User execute(Long id) {
    Optional<User> user = userGateway.findById(id);
    if (user.isEmpty()) {
       throw new UserNotFoundException();
    }
     return user.get();
   }
}
