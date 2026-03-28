package com.multirestaurant.managementapi.domain.exception.menuItem;
public class InvalidProductException extends RuntimeException {
  public InvalidProductException(String message) {
    super(message);
 }
}
