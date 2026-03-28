package com.multirestaurant.managementapi.controller;
import com.multirestaurant.managementapi.application.dto.restaurant.CreateRestaurantRequestDTO;
import com.multirestaurant.managementapi.application.dto.restaurant.RestaurantResponseDTO;
import com.multirestaurant.managementapi.application.mapper.dto.RestaurantResponseMapperDTO;
import com.multirestaurant.managementapi.application.usecase.restaurantUseCase.CreateRestaurantUseCase;
import com.multirestaurant.managementapi.application.usecase.restaurantUseCase.DeleteRestaurantUseCase;
import com.multirestaurant.managementapi.application.usecase.restaurantUseCase.FindAllRestaurantsUseCase;
import com.multirestaurant.managementapi.application.usecase.restaurantUseCase.FindRestaurantByIdUseCase;
import com.multirestaurant.managementapi.domain.model.Restaurant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantResponseMapperDTO restaurantResponseMapperDTO;
    private final CreateRestaurantUseCase createRestaurantUseCase;
    private final FindAllRestaurantsUseCase findAllUseCase;
    private final FindRestaurantByIdUseCase findByIdUseCase;
    private final DeleteRestaurantUseCase deleteUseCase;
    public RestaurantController(CreateRestaurantUseCase createRestaurantUseCase,
                                FindAllRestaurantsUseCase findAllUseCase,
                                FindRestaurantByIdUseCase findByIdUseCase,
                                DeleteRestaurantUseCase deleteUseCase,
                                RestaurantResponseMapperDTO restaurantResponseMapperDTO) {
        this.createRestaurantUseCase = createRestaurantUseCase;
        this.findAllUseCase = findAllUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.deleteUseCase = deleteUseCase;
        this.restaurantResponseMapperDTO = restaurantResponseMapperDTO;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<RestaurantResponseDTO> create(
            @RequestBody CreateRestaurantRequestDTO request) {
        Restaurant restaurant = createRestaurantUseCase.execute(
                request.getName(),
                request.getAddress(),
                request.getCuisineType(),
                request.getOpeningHours(),
                request.getOwnerId()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restaurantResponseMapperDTO.toResponse(restaurant));
    }

    // FIND ALL
    @GetMapping
    public ResponseEntity<List<RestaurantResponseDTO>> findAll() {
        List<Restaurant> restaurants = findAllUseCase.execute();
        List<RestaurantResponseDTO> response = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            response.add(restaurantResponseMapperDTO.toResponse(restaurant));
        }
        return ResponseEntity.ok(response);
    }

    // FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> findById(@PathVariable Long id) {
        Restaurant restaurant = findByIdUseCase.execute(id);
        return ResponseEntity.ok(
                restaurantResponseMapperDTO.toResponse(restaurant)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
