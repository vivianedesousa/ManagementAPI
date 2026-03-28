package com.multirestaurant.managementapi.infrastructure.persistence.repository;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MenuItemJpaRepository extends JpaRepository<MenuItemEntity, Long> {
    List<MenuItemEntity> findByRestaurantId(Long restaurantId);
}
