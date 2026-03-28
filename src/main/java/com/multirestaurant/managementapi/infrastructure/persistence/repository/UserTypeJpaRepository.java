package com.multirestaurant.managementapi.infrastructure.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserTypeEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserTypeJpaRepository extends JpaRepository<UserTypeEntity,Long > {
    // O spring ja criar automaticamneto os mesto do CRUD
   // Optional<UserTypeEntity> findByName(String name);
    Optional<UserTypeEntity> findByNameIgnoreCase(String name);
}