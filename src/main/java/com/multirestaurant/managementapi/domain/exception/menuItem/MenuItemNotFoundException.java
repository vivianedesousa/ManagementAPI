package com.multirestaurant.managementapi.domain.exception.menuItem;

public class MenuItemNotFoundException extends  RuntimeException {
   public  MenuItemNotFoundException(String message){
    super(message);
    }
}
