package com.multirestaurant.managementapi.application.usecase.UserCase;
import com.multirestaurant.managementapi.domain.exception.user.UserNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UpdateUserUseCase {
    private final UserGateway userGateway;
    public UpdateUserUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }
    public User execute(Long id, String name, String email) {
        Optional<User> optionalUser = userGateway.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException();
        }
        User user = optionalUser.get();
        // atualiza usando métodos do domínio
        if (name != null && !name.isBlank()) {
            user = user.changeName(name);
        }
        if (email != null && !email.isBlank()) {
            user = user.changeEmail(email);
        }
        return userGateway.save(user);
    }
}
