package com.multirestaurant.managementapi.domain.gateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import java.util.List;
import java.util.Optional;
public interface MenuItemGateway {
    MenuItem save(MenuItem menuItem);
    List<MenuItem> findByRestaurantId(Long restaurantId);
    Optional<MenuItem> findById(Long id);
    void deleteById(Long id);
}
