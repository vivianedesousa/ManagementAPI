package com.multirestaurant.managementapi.application.usecase.menuItemUseCase;
import com.multirestaurant.managementapi.domain.exception.menuItem.RestaurantMenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.gateway.RestaurantGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;
@Service
    public class CreateMenuItemUseCase {
        private final MenuItemGateway menuItemGateway;
        private final RestaurantGateway restaurantGateway;
        public CreateMenuItemUseCase(MenuItemGateway menuItemGateway,
                                     RestaurantGateway restaurantGateway) {
            this.menuItemGateway = menuItemGateway;
            this.restaurantGateway = restaurantGateway;
        }
        public MenuItem execute(String name,
                                String description,
                                BigDecimal price,
                                boolean dineInOnly,
                                String photoPath,
                                Long restaurantId) {
            //busca restaurante
            Optional<Restaurant> optionalRestaurant = restaurantGateway.findById(restaurantId);
            if (optionalRestaurant.isEmpty()) {
                throw new RestaurantMenuItemNotFoundException("Menu Item was not find");
            }
            Restaurant restaurant = optionalRestaurant.get();
            // cria domínio
            MenuItem menuItem = new MenuItem(null,name,description,price,dineInOnly,photoPath,
                    restaurant);
            // salva via gateway
            MenuItem savedMenuItem = menuItemGateway.save(menuItem);
            return savedMenuItem;
        }
}
