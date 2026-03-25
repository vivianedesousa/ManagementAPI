package com.multirestaurant.managementapi.application.usecase.usertypeUseCase;
import com.multirestaurant.managementapi.domain.gateway.UserTypeGateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import org.springframework.stereotype.Service;
import java.util.List;
// precisa use type get
@Service
public class FindAllUserTypesUseCase {
    private final UserTypeGateway gateway;

    public FindAllUserTypesUseCase(UserTypeGateway gateway) {
        this.gateway = gateway;
    }

    public List<UserType> list() {
        return gateway.findAll();
    }
}
