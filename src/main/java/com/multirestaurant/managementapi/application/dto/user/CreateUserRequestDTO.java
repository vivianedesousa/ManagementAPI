package com.multirestaurant.managementapi.application.dto.user;
 // DTO DE ENTRADA
public class CreateUserRequestDTO {
     private String name;
     private String email;
     private String userType;

     public String getName() {
         return name;
     }

     public String getEmail() {
         return email;
     }

     public String getUserType() {
         return userType;
     }
}

