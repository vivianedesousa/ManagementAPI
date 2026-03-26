package com.multirestaurant.managementapi.infrastructure.persistence.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "restaurants")
public class RestaurantEntity{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false, length = 100)
private String name;

@Column(nullable = false, columnDefinition = "TEXT")
private String address;

@Column(name = "cuisine_type", length = 100)
private String cuisineType;

@Column(name = "opening_hours", length = 100)
private String openingHours;
//Muitos restaurantes → 1 usuário (dono)
//RELACIONAMENTO COM USER
@ManyToOne
@JoinColumn(
        name = "owner_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_restaurants_owner")
)
private UserEntity owner;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getCuisineType() {
    return cuisineType;
}

public void setCuisineType(String cuisineType) {
    this.cuisineType = cuisineType;
}

public String getOpeningHours() {
    return openingHours;
}

public void setOpeningHours(String openingHours) {
    this.openingHours = openingHours;
}

public UserEntity getOwner() {
    return owner;
}

public void setOwner(UserEntity owner) {
    this.owner = owner;
 }
}

