package com.multirestaurant.managementapi.controller;
import com.multirestaurant.managementapi.application.dto.usertype.UserTypeResponseDTO;
import com .multirestaurant.managementapi.application.usecase.usertypeUseCase.*;
import org.springframework.web.bind.annotation.*;
import com.multirestaurant.managementapi.application.mapper.dto.UserTypeResponseMapperDTO;
import java.util.List;
  // "O controller recebe requisições e retorna DTOs, " +
    //       "o use case executa a lógica de negócio, " +
    //       "o domínio valida regras e o gateway acessa os dados."

//Por que não usa Entity no controller?
//PARA NAO ACOPLA A api COM A INFRAESTRUTURA
// ESTUDAR
// “O controller recebe os dados via DTO, o use case executa a lógica de negócio,
// o domínio valida as regras e o gateway persiste os dados.”
@RestController
@RequestMapping("/user-types")
public class UserTypeController {
        private final FindAllUserTypesUseCase findAllUseCase;
        private final FindUserTypeByIdUseCase findByIdUseCase;
        private final FindUserTypeByNameUseCase findByNameUseCase;
        private final UserTypeResponseMapperDTO mapper;

        public UserTypeController(
                FindAllUserTypesUseCase findAllUseCase,
                FindUserTypeByIdUseCase findByIdUseCase,
                FindUserTypeByNameUseCase findByNameUseCase,
                UserTypeResponseMapperDTO mapper
        ) {
            this.findAllUseCase = findAllUseCase;
            this.findByIdUseCase = findByIdUseCase;
            this.findByNameUseCase = findByNameUseCase;
            this.mapper = mapper;
        }

        // GET /user-types
        @GetMapping
        public List<UserTypeResponseDTO> findAll() {
            return findAllUseCase.list()
                    .stream()
                    .map(mapper::toResponse)
                    .toList();
        }

        // GET /user-types/{id}
        @GetMapping("/{id}")
        public UserTypeResponseDTO findById(@PathVariable Long id) {
            return mapper.toResponse(
                    findByIdUseCase.execute(id)
            );
        }
         // vai traz isso SELECT * FROM user_types WHERE name = 'customer';
        // GET /user-types/name/{name}
        @GetMapping("/name/{name}")
        public UserTypeResponseDTO findByName(@PathVariable String name) {
            return mapper.toResponse(
                    findByNameUseCase.execute(name)
            );
        }
}
