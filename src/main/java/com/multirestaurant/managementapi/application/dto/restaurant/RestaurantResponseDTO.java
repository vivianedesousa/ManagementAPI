package com.multirestaurant.managementapi.application.dto.restaurant;

public class RestaurantResponseDTO {
  private Long id;
  private String name;
  private String address;
  private String cuisineType;
  private String openingHours;
  private String ownerName;
  public RestaurantResponseDTO (Long id
                                ,String name,
                                String address,
                                String cuisineType,
                                String  openingHours,
                                String ownerName){
    this.id = id;
    this.name = name;
    this.address = address;
    this.cuisineType = cuisineType;
    this.openingHours = openingHours;
    this.ownerName= ownerName; // novo
  }
   //gettes and setters
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

  public String getOwnerName() {
      return ownerName;
  }

  public void setOwnerName(String ownerName) {
  this.ownerName = ownerName;
 }
}
