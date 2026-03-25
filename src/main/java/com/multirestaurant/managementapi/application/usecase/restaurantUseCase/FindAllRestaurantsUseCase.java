package com.multirestaurant.managementapi.application.usecase.restaurantUseCase;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import java.util.List;
public class FindAllRestaurantsUseCase {
  private  final RestaurantGateway restaurantGateway;
  public FindAllRestaurantsUseCase(RestaurantGateway restaurantGateway) {
    this.restaurantGateway = restaurantGateway;
    }
  public List<Restaurant> execute() {
    return restaurantGateway.findAll();
}
}
