package com.multirestaurant.managementapi.domain.exception.restaurant;
//"O caso de uso busca um restaurante pelo identificador e lança exceção caso não exista,
// garantindo consistência na aplicação.
public class RestaurantNotFoundException extends RuntimeException{
  public  RestaurantNotFoundException(){
    super("Restaurant not found");
    }
}
