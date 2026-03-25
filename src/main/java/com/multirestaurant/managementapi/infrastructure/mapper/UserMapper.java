package com.multirestaurant.managementapi.infrastructure.mapper;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

// PARA CRIAR MEU MAP VOU PRECISA DISSO
//"O mapper é responsável por converter entidades de persistência em objetos de domínio e vice-versa."
@Component
public class UserMapper {
    private final UserTypeMapper userTypeMapper;
    public UserMapper(UserTypeMapper userTypeMapper) {
        this.userTypeMapper = userTypeMapper;
    }
    // Domain → Entity
     // transforma User →  para UserEntity
    // Entity pega todos os dominios e transform apara salvar no DB
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        if (user.identity() != null) {
            entity.setId(user.identity());
        }
        entity.setName(user.name());
        entity.setEmail(user.email());
        entity.setUserType(userTypeMapper.toEntity(user.userType()));
        return entity;
    }
     // regra de ouro Mapper de entidade chama mapper de entidade relacionada
    // To Domain
    // Entity → Domain
     // pegar DBUserEntity → transforma para  User
     // pegar o banco para o dominio
    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                userTypeMapper.toDomain(entity.getUserType())
        );
    }
}

