package com.multirestaurant.managementapi.application.usecase.restaurantUseCase;
import com.multirestaurant.managementapi.domain.exception.restaurant.RestaurantNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FindRestaurantByIdUseCase {
    private final RestaurantGateway restaurantGateway;
    public FindRestaurantByIdUseCase(RestaurantGateway restaurantGateway) {
        this.restaurantGateway = restaurantGateway;
    }
    public Restaurant execute(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantGateway.findById(id);
        if (!optionalRestaurant.isPresent()) {
            throw new RestaurantNotFoundException();
        }
        return optionalRestaurant.get();
    }
}

