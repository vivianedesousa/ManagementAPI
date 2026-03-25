package com.multirestaurant.managementapi.domain.gateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
// contrato de acesso ao dados do db
// a minha USE CASE E E FEITA EMCIMA DO DOMINIO cmada
public interface UserTypeGateway {
  List<UserType> findAll();
  Optional<UserType> findById(Long id);
  Optional<UserType> findByName(String name);

  // DELETE (DELETE)
  //void deleteById(Long id);
  // Porque os tipos de usuário são fixos e representam categorias do sistema,
  //não dados dinâmicos manipuláveis.
   // so fas estes aqui
  // List<UserType> findAll();
  //    Optional<UserType> findById(Long id);
}
