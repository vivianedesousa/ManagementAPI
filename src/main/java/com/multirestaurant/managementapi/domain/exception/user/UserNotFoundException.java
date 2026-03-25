package com.multirestaurant.managementapi.domain.exception.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
    super("User was not  found");
    }
}
