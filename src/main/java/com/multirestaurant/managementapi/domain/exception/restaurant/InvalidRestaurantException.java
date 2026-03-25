package com.multirestaurant.managementapi.domain.exception.restaurant;

public class InvalidRestaurantException  extends RuntimeException{
    public InvalidRestaurantException (String message){
        super(message);
    }
}
