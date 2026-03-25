package com.multirestaurant.managementapi.application.usecase.UserCase;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FindAllUsersUseCase {
    private final UserGateway userGateway;

    public FindAllUsersUseCase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<User> execute() {
        return userGateway.findAll();
    }
}
