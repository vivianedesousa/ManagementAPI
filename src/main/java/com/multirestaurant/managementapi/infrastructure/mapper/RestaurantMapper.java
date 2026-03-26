package com.multirestaurant.managementapi.infrastructure.mapper;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.RestaurantEntity;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    private final UserMapper userMapper;
    public RestaurantMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //DOMAIN → ENTITY
    public RestaurantEntity toEntity(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(restaurant.identity());
        entity.setName(restaurant.name());
        entity.setAddress(restaurant.address());
        entity.setCuisineType(restaurant.cuisineType());
        entity.setOpeningHours(restaurant.openingHours());

        // relacionamento
        UserEntity ownerEntity = userMapper.toEntity(restaurant.owner());
        entity.setOwner(ownerEntity);
        return entity;
    }
    //ENTITY → DOMAIN
    public Restaurant toDomain(RestaurantEntity entity) {
        if (entity == null) {
            return null;
        }

        User owner = userMapper.toDomain(entity.getOwner());
        return new Restaurant(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCuisineType(),
                entity.getOpeningHours(),
                owner
        );
    }

}
