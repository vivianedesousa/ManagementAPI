package com.multirestaurant.managementapi.domain.exception.usertype;
public class UserTypeAlreadyExistsException extends RuntimeException{
    public UserTypeAlreadyExistsException() {
        super("UserType already exists");
    }
}
