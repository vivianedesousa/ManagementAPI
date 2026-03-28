package com.multirestaurant.managementapi.infrastructure.gateway;
import com.multirestaurant.managementapi.domain.gateway.MenuItemGateway;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import com.multirestaurant.managementapi.infrastructure.mapper.MenuItemMapper;
import com.multirestaurant.managementapi.infrastructure.persistence.repository.MenuItemJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
//"Os itens do cardápio são modelados como entidades dependentes do restaurante, sendo persistidos com chave
//estrangeira e acessados através de um gateway.
@Component
public class MenuItemGatewayImpl implements MenuItemGateway {
    private final MenuItemJpaRepository repository;
    private final MenuItemMapper menuItemMapper;
    public MenuItemGatewayImpl(MenuItemJpaRepository repository,
                               MenuItemMapper menuItemMapper) {
        this.repository = repository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemMapper.toDomain(repository.save(menuItemMapper.toEntity(menuItem)));
    }

    @Override
    public List<MenuItem> findByRestaurantId(Long restaurantId) {
        return repository.findByRestaurantId(restaurantId)
                .stream()
                .map(menuItemMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<MenuItem> findById(Long id) {
        return repository.findById(id).map(menuItemMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

