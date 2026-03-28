package com.multirestaurant.managementapi.application.usecase.menuItemUseCase;
import com.multirestaurant.managementapi.domain.exception.menuItem.MenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class FindMenuItemByIdUseCase {
    private final MenuItemGateway menuItemGateway;
    public FindMenuItemByIdUseCase(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }
    public MenuItem execute(Long id) {
        Optional<MenuItem> optionalMenuItem = menuItemGateway.findById(id);
        if (optionalMenuItem.isEmpty()) {
            throw new MenuItemNotFoundException("Menu item not found");
        }
        MenuItem menuItem = optionalMenuItem.get();
        return menuItem;
    }
}
