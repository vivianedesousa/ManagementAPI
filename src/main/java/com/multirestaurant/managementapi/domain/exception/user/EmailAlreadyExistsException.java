package com.multirestaurant.managementapi.domain.exception.user;
public class EmailAlreadyExistsException extends RuntimeException {
  public  EmailAlreadyExistsException(){
    super("Email already exists");
 }
}
