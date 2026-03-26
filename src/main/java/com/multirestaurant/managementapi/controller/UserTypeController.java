package com.multirestaurant.managementapi.controller;
import com.multirestaurant.managementapi.application.dto.usertype.UserTypeResponseDTO;
import com .multirestaurant.managementapi.application.usecase.usertypeUseCase.*;
import com.multirestaurant.managementapi.domain.model.UserType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.multirestaurant.managementapi.application.mapper.dto.UserTypeResponseMapperDTO;

import java.util.ArrayList;
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
        private final UserTypeResponseMapperDTO userTypeResponseMapperDTO;

        public UserTypeController(
                FindAllUserTypesUseCase findAllUseCase,
                FindUserTypeByIdUseCase findByIdUseCase,
                FindUserTypeByNameUseCase findByNameUseCase,
                UserTypeResponseMapperDTO mapper
        ) {
            this.findAllUseCase = findAllUseCase;
            this.findByIdUseCase = findByIdUseCase;
            this.findByNameUseCase = findByNameUseCase;
            this.userTypeResponseMapperDTO = mapper;
        }

        // GET /user-types   foi mudando tbm
        @GetMapping
        public ResponseEntity<List<UserTypeResponseDTO>> findAll() {
            List<UserType> userTypes = findAllUseCase.list();
            List<UserTypeResponseDTO> response = new ArrayList<>();
            for (UserType userType : userTypes) {
                response.add(userTypeResponseMapperDTO.toResponse(userType));
            }
            return ResponseEntity.ok(response);
        }

        // GET /user-types/{id}
        @GetMapping("/{id}")
        public UserTypeResponseDTO findById(@PathVariable Long id) {
            return userTypeResponseMapperDTO.toResponse(
                    findByIdUseCase.execute(id)
            );
        }
         // vai traz isso SELECT * FROM user_types WHERE name = 'customer';
        // GET /user-types/name/{name}
        @GetMapping("/name/{name}")
        public UserTypeResponseDTO findByName(@PathVariable String name) {
            return userTypeResponseMapperDTO.toResponse(
                    findByNameUseCase.execute(name)
            );
        }
}
