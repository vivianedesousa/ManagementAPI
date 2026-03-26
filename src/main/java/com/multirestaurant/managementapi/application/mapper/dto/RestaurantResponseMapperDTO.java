package com.multirestaurant.managementapi.application.mapper.dto;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import com.multirestaurant.managementapi.application.dto.restaurant.RestaurantResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class RestaurantResponseMapperDTO {
  public RestaurantResponseDTO toResponse(Restaurant restaurant) {
    if (restaurant == null) {
      return null;
    }
    return new RestaurantResponseDTO(
      restaurant.identity(),
      restaurant.name(),
      restaurant.address(),
      restaurant.cuisineType(),
      restaurant.openingHours(),
      restaurant.owner().name() //novo
   );
  }
}
