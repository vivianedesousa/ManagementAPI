package com.multirestaurant.managementapi.infrastructure.persistence.repository;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
//"A implementação do gateway utiliza o repository e o mapper para persistir
 //"e recuperar dados, mantendo o domínio desacoplado da infraestrutura."
@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity,Long > {
    Optional<UserEntity> findByEmail(String email);

}
