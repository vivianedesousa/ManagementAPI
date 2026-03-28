package com.multirestaurant.managementapi.application.usecase.menuItemUseCase;
import com.multirestaurant.managementapi.domain.exception.menuItem.MenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FindMenuItemsByRestaurantUseCase {
    private final MenuItemGateway menuItemGateway;
    public FindMenuItemsByRestaurantUseCase(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }
    public List<MenuItem> execute(Long restaurantId) {
        List<MenuItem> menuItems = menuItemGateway.findByRestaurantId(restaurantId);
        if (menuItems.isEmpty()) {
            throw new MenuItemNotFoundException("No menu items found for this restaurant");
        }
        return menuItems;
    }
}
