package com.multirestaurant.managementapi.application.usecase.UserCase;
import com.multirestaurant.managementapi.domain.exception.user.UserNotFoundException;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DeleteUserUseCase {
   private final UserGateway userGateway;
   public DeleteUserUseCase(UserGateway userGateway) {
   this.userGateway = userGateway;
     }
     public void execute(Long id) {
      Optional<User> user = userGateway.findById(id);
      if (user.isEmpty()) {
        throw new UserNotFoundException();
        }
        userGateway.deleteById(id);
      }
   }
