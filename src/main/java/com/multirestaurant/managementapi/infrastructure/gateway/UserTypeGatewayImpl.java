package com.multirestaurant.managementapi.infrastructure.gateway;
import com.multirestaurant.managementapi.domain.gateway.UserTypeGateway;
import com.multirestaurant.managementapi.domain.model.UserType;
import com.multirestaurant.managementapi.infrastructure.mapper.UserTypeMapper;
import com.multirestaurant.managementapi.infrastructure.persistence.repository.UserTypeJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
 // esta camada fala com DB
 //@Component // trocado  para repository
 @Component
public class UserTypeGatewayImpl implements UserTypeGateway {
     private final UserTypeJpaRepository repository;
     private final UserTypeMapper userTypeMapper;

     public UserTypeGatewayImpl(UserTypeJpaRepository repository,
                                UserTypeMapper userTypeMapper) {
         this.repository = repository;
         this.userTypeMapper = userTypeMapper;
     }

     @Override
     public List<UserType> findAll() {
         return repository.findAll()
                 .stream()
                 .map(userTypeMapper::toDomain)
                 .toList();
     }

     // select from* id e transforma essa lista e optinal
     @Override
     public Optional<UserType> findById(Long id) {
         return repository.findById(id)
                 .map(userTypeMapper::toDomain);
     }

     @Override
     public Optional<UserType> findByName(String name) {
         ////  return repository.findByName(name)
         return repository.findByNameIgnoreCase(name)
                 .map(userTypeMapper::toDomain);
     }
 }

