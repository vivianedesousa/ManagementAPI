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
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public UserResponseDTO create(@RequestBody CreateUserRequestDTO request) {

        return userResponseMapperDTO.toResponse(
                createUseCase.execute(
                        request.getName(),
                        request.getEmail(),
                        request.getUserType()
                )
        );
    }

    // GET ALL
    @GetMapping
    public List<UserResponseDTO> findAll() {
        return findAllUseCase.execute()
                .stream()
                .map(userResponseMapperDTO ::toResponse)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserResponseDTO findById(@PathVariable Long id) {
        return userResponseMapperDTO.toResponse(
                findByIdUseCase.execute(id)
        );
    }

    // PUT
    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable Long id,
                                  @RequestBody UpdateUserRequestDTO request) {

        return userResponseMapperDTO.toResponse(
                updateUseCase.execute(
                        id,
                        request.getName(),
                        request.getEmail()
                )
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
    }
}
