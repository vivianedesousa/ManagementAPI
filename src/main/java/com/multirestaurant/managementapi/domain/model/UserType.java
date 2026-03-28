package com.multirestaurant.managementapi.domain.model;
import com .multirestaurant.managementapi.domain.exception.usertype.InvalidUserTypeNameException;

public class UserType {
  public static final String CUSTOMER = "CUSTOMER";
  public static final String RESTAURANT_OWNER = "OWNER";
  private final Long id;
  private final String name;
  public UserType(Long id, String name) {
      validate(name);
        this.id = id;
        this.name = name;
     }

  private void validate(String name) {
      if (name == null || name.isBlank()) {
      throw new InvalidUserTypeNameException();
     }
  }

     public Long identity() {
        return id;
    }

     public String name() {
         return name;
    }

    public UserType changeName(String newName) {
          validate(newName);
    return new UserType(this.id, newName);
     }
  }


