package com.multirestaurant.managementapi.application.usecase.restaurantUseCase;
import com.multirestaurant.managementapi.domain.exception.restaurant.UserNotRestaurantOwnerException;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.gateway.UserGateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import com.multirestaurant.managementapi.domain.model.User;
import com.multirestaurant.managementapi.domain.exception.user.UserNotFoundException;
import java.util.Optional;
public class CreateRestaurantUseCase {
        private final RestaurantGateway restaurantGateway;
        private final UserGateway userGateway;

        public CreateRestaurantUseCase(RestaurantGateway restaurantGateway,
                                       UserGateway userGateway) {
            this.restaurantGateway = restaurantGateway;
            this.userGateway = userGateway;
        }

        public Restaurant execute(String name,
                                  String address,
                                  String cuisineType,
                                  String openingHours,
                                  Long ownerId) {
            // 1. buscar usuário
            Optional<User> optionalUser = userGateway.findById(ownerId);
            if (!optionalUser.isPresent()) {
                throw new UserNotFoundException();
            }
            User owner = optionalUser.get();
            // 2. regra principal (pode deixar no domínio também)
            if (!owner.isRestaurantOwner()) {
                throw new UserNotRestaurantOwnerException();
            }
            // 3. criar restaurante
            Restaurant restaurant = new Restaurant(
                    null,
                    name,
                    address,
                    cuisineType,
                    openingHours,
                    owner
            );

            // 4. salvar
            return restaurantGateway.save(restaurant);
        }
}

