package com.multirestaurant.managementapi.application.usecase.menuItemUseCase;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import com.multirestaurant.managementapi.domain.exception.menuItem.MenuItemNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class DeleteMenuItemUseCase {
    private final MenuItemGateway menuItemGateway;
    public DeleteMenuItemUseCase(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }

    public void execute(Long id) {
        Optional<MenuItem> optionalMenuItem = menuItemGateway.findById(id);
        if (optionalMenuItem.isEmpty()) {
            throw new MenuItemNotFoundException("Menu item not found");
        }
        menuItemGateway.deleteById(id);
    }
}
