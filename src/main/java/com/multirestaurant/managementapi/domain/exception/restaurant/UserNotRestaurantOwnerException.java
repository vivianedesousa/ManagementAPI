package com.multirestaurant.managementapi.domain.exception.restaurant;

public class UserNotRestaurantOwnerException extends RuntimeException{
    public  UserNotRestaurantOwnerException(){
        super("User is not restaurant owner");
    }
}
