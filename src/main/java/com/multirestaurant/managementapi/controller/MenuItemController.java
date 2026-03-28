package com.multirestaurant.managementapi.controller;
import com.multirestaurant.managementapi.application.dto.menuItem.CreateMenuItemRequestDTO;
import com.multirestaurant.managementapi.application.dto.menuItem.MenuItemResponseDTO;
import com.multirestaurant.managementapi.application.dto.menuItem.UpdateMenuItemRequestDTO;
import com.multirestaurant.managementapi.application.usecase.menuItemUseCase.*;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import com.multirestaurant.managementapi.application.mapper.dto.MenuItemResponseMapperDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1/menu-items")
  public class MenuItemController {

  private final  CreateMenuItemUseCase createUseCase;
  private final FindMenuItemsByRestaurantUseCase findByRestaurantUseCase;
  private final FindMenuItemByIdUseCase findByIdUseCase;
  private final DeleteMenuItemUseCase deleteUseCase;
  private final UpdateMenuItemUseCase updateUseCase;
  private final MenuItemResponseMapperDTO menuItemResponseMapperDTO;

    public MenuItemController(CreateMenuItemUseCase createUseCase,
                              FindMenuItemsByRestaurantUseCase findByRestaurantUseCase,
                              FindMenuItemByIdUseCase findByIdUseCase,
                              DeleteMenuItemUseCase deleteUseCase,
                              UpdateMenuItemUseCase updateUseCase,
                              MenuItemResponseMapperDTO menuItemResponseMapperDTO) {

        this.createUseCase = createUseCase;
        this.findByRestaurantUseCase = findByRestaurantUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.deleteUseCase = deleteUseCase;
        this.updateUseCase = updateUseCase;
        this.menuItemResponseMapperDTO = menuItemResponseMapperDTO;
    }

        // CREATE
        @PostMapping
        public ResponseEntity<MenuItemResponseDTO> create(
                @RequestBody CreateMenuItemRequestDTO request) {
            MenuItem menuItem = createUseCase.execute(
                    request.getName(),
                    request.getDescription(),
                    request.getPrice(),
                    request.isDineInOnly(),
                    request.getPhotoPath(),
                    request.getRestaurantId());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(menuItemResponseMapperDTO.toResponse(menuItem));
        }

        // FIND BY RESTAURANT
        @GetMapping("/{id}")
        public ResponseEntity<List<MenuItemResponseDTO>> findByRestaurant(
                @PathVariable Long id) {
            List<MenuItem> menuItems = findByRestaurantUseCase.execute(id);
            List<MenuItemResponseDTO> response = new ArrayList<>();
            for (MenuItem menuItem : menuItems) {
                response.add(menuItemResponseMapperDTO.toResponse(menuItem));
            }
            return ResponseEntity.ok(response);
        }

        // FIND BY ID
        @GetMapping("/{id}")
        public ResponseEntity<MenuItemResponseDTO> findById(@PathVariable Long id) {
            MenuItem menuItem = findByIdUseCase.execute(id);
            return ResponseEntity.ok(
                    menuItemResponseMapperDTO.toResponse(menuItem)
            );
        }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemResponseDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateMenuItemRequestDTO request) {

        MenuItem updated = updateUseCase.execute(
                id,
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.isDineInOnly(),
                request.getPhotoPath()
        );

        return ResponseEntity.ok(
                menuItemResponseMapperDTO.toResponse(updated)
        );
    }

        // DELETE
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            deleteUseCase.execute(id);
            return ResponseEntity.noContent().build();
        }
  }
