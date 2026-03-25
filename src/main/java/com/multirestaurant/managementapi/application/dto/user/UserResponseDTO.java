package com.multirestaurant.managementapi.application.dto.user;
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String userType;

    public UserResponseDTO(Long id, String name, String email, String userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

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
