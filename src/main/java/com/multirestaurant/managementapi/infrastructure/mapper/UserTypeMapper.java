package com.multirestaurant.managementapi.infrastructure.mapper;
 //tratutor das camadas  entre o meu modelo de negocio de Dominio(MODEL=userType)
 //Domian (USERTYPE) da  camada infra Entity (UsertypeEntity)  converte e virse versa
import com.multirestaurant.managementapi.domain.model.UserType;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserTypeEntity;
import org.springframework.stereotype.Component;
// @ Component Classe devera ser gerenciado pelo Core container do Spring
@Component
public class UserTypeMapper{
//    Domain → Entity (salvar no banco)
//    UserType → UserTypeEntity → Banco
  public UserTypeEntity toEntity(UserType userType) {
      UserTypeEntity entity = new UserTypeEntity();
      // Só seta ID se NÃO for null (update)
      if (userType.identity() != null) {
          entity.setId(userType.identity());
      }
      entity.setName(userType.name());
      return entity;
  }
//      entity.setId(userType.identity());
//      entity.setName(userType.name());

   // Entity → Domain (buscar do banco) Banco → UserTypeEntity → UserType
    //Banco → UserTypeEntity → PARA  UserType
    // RETORNADO
   // Entity → Domain
  public UserType toDomain(UserTypeEntity entity){
      if (entity == null) return null; // evitar um erro (NullPointerException)
     return new UserType(
     entity.getId(),
     entity.getName()
     );
  }
}
