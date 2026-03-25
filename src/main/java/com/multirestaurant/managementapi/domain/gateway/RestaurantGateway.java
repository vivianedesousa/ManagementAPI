package com.multirestaurant.managementapi.domain.gateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import java.util.List;
import java.util.Optional;
public interface RestaurantGateway {
    Restaurant save(Restaurant restaurant);
    List<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    void deleteById(Long id);
}
