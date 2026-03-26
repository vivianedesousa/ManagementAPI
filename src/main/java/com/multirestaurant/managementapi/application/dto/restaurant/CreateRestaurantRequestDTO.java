package com.multirestaurant.managementapi.application.dto.restaurant;

public class CreateRestaurantRequestDTO {
  private String name;
  private String address;
  private String cuisineType;
  private String openingHours;
  private Long ownerId;
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
  public Long getOwnerId() {
   return ownerId;
  }
  public void setOwnerId(Long ownerId) {
     this.ownerId = ownerId;
   }
}
