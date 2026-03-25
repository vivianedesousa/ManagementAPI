package com.multirestaurant.managementapi.domain.gateway;
import com.multirestaurant.managementapi.domain.model.User;
import java .util.List;
import java.util.Optional;
//O Gateway define o contrato de acesso a dados, desacoplando o domínio da infraestrutura."
public interface UserGateway {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
  // para evitar null e obrigar tratar se nao ter valor  nao estourar um EXC
    Optional<User> findByEmail(String email); // ⭐ opcional
    void deleteById(Long id);
}
