package com.multirestaurant.managementapi.domain.exception.usertype;
public class InvalidUserTypeNameException extends RuntimeException {
  public InvalidUserTypeNameException (){
    super("UserType name cannot be empty");
  }
}
