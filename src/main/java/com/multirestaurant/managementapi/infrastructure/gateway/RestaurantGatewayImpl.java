package com.multirestaurant.managementapi.infrastructure.gateway;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import com.multirestaurant.managementapi.infrastructure.persistence.repository.RestaurantJpaRepository;
import com.multirestaurant.managementapi.infrastructure.mapper.RestaurantMapper;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component

public class RestaurantGatewayImpl implements RestaurantGateway {
    private final RestaurantMapper restaurantMapper;
    private final RestaurantJpaRepository repository;
    public RestaurantGatewayImpl(RestaurantJpaRepository repository,
                                 RestaurantMapper restaurantMapper) {
        this.repository = repository;
        this.restaurantMapper= restaurantMapper;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        RestaurantEntity entity = restaurantMapper.toEntity(restaurant);
        RestaurantEntity saved = repository.save(entity);
        return restaurantMapper.toDomain(saved);
    }

    @Override
    public List<Restaurant> findAll() {
        return repository.findAll()
                .stream()
                .map(restaurantMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        Optional<RestaurantEntity> entity = repository.findById(id);
        if (entity.isEmpty()) {
            return Optional.empty();
        }
       return Optional.of(restaurantMapper.toDomain(entity.get()));
    }

    @Override
    public void deleteById(Long id) {
      repository.deleteById(id);
    }
}

