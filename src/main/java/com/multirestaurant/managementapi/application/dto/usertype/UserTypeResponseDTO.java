package com.multirestaurant.managementapi.application.dto.usertype;
//Representar os dados que vão para a API
// CARREGAR OS DADOS
// DTO Transportar dados entre camadas (principalmente API ↔ cliente)
public class UserTypeResponseDTO {
    private Long id;
    private String name;

    public UserTypeResponseDTO(Long id,String name){
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
