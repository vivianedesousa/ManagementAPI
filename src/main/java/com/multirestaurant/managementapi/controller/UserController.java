package com.multirestaurant.managementapi.controller;
import com.multirestaurant.managementapi.application.dto.user.CreateUserRequestDTO;
import com.multirestaurant.managementapi.application.dto.user.UserResponseDTO;
import com.multirestaurant.managementapi.application.mapper.dto.UserResponseMapperDTO;
import com.multirestaurant.managementapi.application.usecase.UserCase.CreateUserUseCase;
import com.multirestaurant.managementapi.application.usecase.UserCase.DeleteUserUseCase;
import com.multirestaurant.managementapi.application.usecase.UserCase.FindAllUsersUseCase;
import com.multirestaurant.managementapi.application.usecase.UserCase.UpdateUserUseCase;
import com.multirestaurant.managementapi.application.usecase.UserCase.FindUserByIdUseCase;
import com.multirestaurant.managementapi.application.dto.user.UpdateUserRequestDTO;
import com.multirestaurant.managementapi.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//Controller → expõe API
//Controller → DTO → UseCase → Domain → Gateway → Infra → DB
@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUseCase;
    private final FindUserByIdUseCase findByIdUseCase;
    private final FindAllUsersUseCase findAllUseCase;
    private final UpdateUserUseCase updateUseCase;
    private final DeleteUserUseCase deleteUseCase;
    private final UserResponseMapperDTO  userResponseMapperDTO;

    public UserController(
            CreateUserUseCase createUseCase,
            FindUserByIdUseCase findByIdUseCase,
            FindAllUsersUseCase findAllUseCase,
            UpdateUserUseCase updateUseCase,
            DeleteUserUseCase deleteUseCase,
            UserResponseMapperDTO userResponseMapperDTO
    ) {
        this.createUseCase = createUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.findAllUseCase = findAllUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.userResponseMapperDTO = userResponseMapperDTO;
    }
    // CREATE
    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody CreateUserRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(
                userResponseMapperDTO.toResponse(
                        createUseCase.execute(
                                request.getName(),
                                request.getEmail(),
                                request.getUserType()
                        )
                )
        );
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {

        List<User> users = findAllUseCase.execute();
        List<UserResponseDTO> response = new ArrayList<>();
        for (User u : users) {
            response.add(userResponseMapperDTO.toResponse(u));
        }
        return ResponseEntity.ok(response);
    }
    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(
                userResponseMapperDTO.toResponse(
                        findByIdUseCase.execute(id)
                )
        );
    }
   // put
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,
                                                  @RequestBody UpdateUserRequestDTO request) {
        return ResponseEntity.ok(
                userResponseMapperDTO.toResponse(
                        updateUseCase.execute(
                                id,
                                request.getName(),
                                request.getEmail()
                        )
                )
        );
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
        return ResponseEntity.noContent().build();
}  }

