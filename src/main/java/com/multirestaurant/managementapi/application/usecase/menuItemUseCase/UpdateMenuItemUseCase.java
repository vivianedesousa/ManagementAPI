package com.multirestaurant.managementapi.application.usecase.menuItemUseCase;
import com.multirestaurant.managementapi.domain.exception.menuItem.MenuItemNotFoundException;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;
@Service
public class UpdateMenuItemUseCase {
    private final MenuItemGateway menuItemGateway;
    public UpdateMenuItemUseCase(MenuItemGateway menuItemGateway) {
        this.menuItemGateway = menuItemGateway;
    }
    public MenuItem execute(Long id,
                            String name,
                            String description,
                            BigDecimal price,
                            boolean dineInOnly,
                            String photoPath) {
        // 🔍 busca item existente
        Optional<MenuItem> optionalMenuItem = menuItemGateway.findById(id);
        if (optionalMenuItem.isEmpty()) {
            throw new MenuItemNotFoundException("Menu item not found");
        }
        MenuItem existingMenuItem = optionalMenuItem.get();
        //ria novo objeto atualizado (mantém restaurant)
        MenuItem updatedMenuItem = new MenuItem(
                id,
                name,
                description,
                price,
                dineInOnly,
                photoPath,
                existingMenuItem.restaurant()
        );
        return menuItemGateway.save(updatedMenuItem);
    }
}
