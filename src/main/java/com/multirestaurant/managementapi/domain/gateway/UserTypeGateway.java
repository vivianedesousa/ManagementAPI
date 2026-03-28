package com.multirestaurant.managementapi.domain.gateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import java.util.List;
import java.util.Optional;

public interface UserTypeGateway {
  List<UserType> findAll();
  Optional<UserType> findById(Long id);
  Optional<UserType> findByName(String name);
}
