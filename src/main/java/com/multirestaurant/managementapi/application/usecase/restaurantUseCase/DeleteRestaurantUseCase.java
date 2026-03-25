package com.multirestaurant.managementapi.application.usecase.restaurantUseCase;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import com.multirestaurant.managementapi.domain.exception.restaurant.RestaurantNotFoundException;
import java.util.Optional;
public class DeleteRestaurantUseCase {
        private final RestaurantGateway restaurantGateway;
        public DeleteRestaurantUseCase(RestaurantGateway restaurantGateway) {
            this.restaurantGateway = restaurantGateway;
        }
        public void execute(Long id) {
            Optional<Restaurant> optionalRestaurant = restaurantGateway.findById(id);
            if (!optionalRestaurant.isPresent()) {
                throw new RestaurantNotFoundException();
         }
            restaurantGateway.deleteById(id);
  }
}
