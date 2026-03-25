package com.multirestaurant.managementapi.application.usecase.UserCase;
import com.multirestaurant.managementapi.domain.exception.user.EmailAlreadyExistsException;
import com.multirestaurant.managementapi.domain.exception.usertype.UserTypeNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.domain.gateway.UserTypeGateway;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.domain.model.UserType;
import org.springframework.stereotype.Service;;
import java.util.Optional;
// sua regra e criar usuário + associar UserType
@Service
public class CreateUserUseCase {
 private final UserGateway userGateway;
 private final UserTypeGateway userTypeGateway;

 public CreateUserUseCase(UserGateway userGateway,
                          UserTypeGateway userTypeGateway) {
  this.userGateway = userGateway;
  this.userTypeGateway = userTypeGateway;
 }
 public User execute(String name, String email, String userTypeName) {

  // verifica se email já existe
  Optional<User> existingUser = userGateway.findByEmail(email);
  if (existingUser.isPresent()) {
   throw new EmailAlreadyExistsException();
  }
  // busca tipo de usuário
  Optional<UserType> optionalType = userTypeGateway.findByName(userTypeName);
  if (optionalType.isEmpty()) {
   throw new UserTypeNotFoundException("User type not found");
  }
  UserType userType = optionalType.get();

  // cria usuário
  User user = new User(null, name, email, userType);

  return userGateway.save(user);
 }
}