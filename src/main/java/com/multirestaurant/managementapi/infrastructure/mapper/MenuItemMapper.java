package com.multirestaurant.managementapi.infrastructure.mapper;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.MenuItemEntity;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class MenuItemMapper {
  private final RestaurantMapper restaurantMapper;
  public MenuItemMapper(RestaurantMapper restaurantMapper) {
    this.restaurantMapper = restaurantMapper;
  }

  public MenuItemEntity toEntity(MenuItem menuItem) {
    if (menuItem == null) {
      return null;
    }

    MenuItemEntity menuItemEntity = new MenuItemEntity();
    menuItemEntity.setId(menuItem.identity());
    menuItemEntity.setName(menuItem.name());
    menuItemEntity.setDescription(menuItem.description());
    menuItemEntity.setPrice(menuItem.price());
    menuItemEntity.setDineInOnly(menuItem.dineInOnly());
    menuItemEntity.setPhotoPath(menuItem.photoPath());
    menuItemEntity.setRestaurant(
    restaurantMapper.toEntity(menuItem.restaurant()));
      return menuItemEntity;
    }
    public MenuItem toDomain(MenuItemEntity menuItemEntity) {
    if (menuItemEntity== null) {
      return null;
    }
    return new MenuItem(
    menuItemEntity.getId(),
    menuItemEntity.getName(),
    menuItemEntity.getDescription(),
    menuItemEntity.getPrice(),
    menuItemEntity.isDineInOnly(),
    menuItemEntity.getPhotoPath(),
    restaurantMapper.toDomain(menuItemEntity.getRestaurant())
            );
        }
    }
