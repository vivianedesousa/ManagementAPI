package com.multirestaurant.managementapi.domain.model;
import com.multirestaurant.managementapi.domain.exception.user.InvalidUserException;
// precis afazer a exercoes
public class User {
        private final Long id;
        private final String name;
        private final String email;
        private final UserType userType;

        public User(Long id, String name, String email, UserType userType) {
            validate(name, email, userType);
            this.id = id;
            this.name = name;
            this.email = email;
            this.userType = userType;
        }

        private void validate(String name, String email, UserType userType) {
            if (name == null || name.isBlank()) {
                throw new  InvalidUserException("Name is required");
            }
            if (email == null || email.isBlank()) {
                throw new  InvalidUserException("Email is required");
            }
            if (userType == null) {
                throw new  InvalidUserException("UserType is required");
            }
        }

        public Long identity() {
            return id;
        }

        public String name() {
            return name;
        }

        public String email() {
            return email;
        }

        public UserType userType() {
            return userType;
        }

        public boolean isRestaurantOwner() {
            return this.userType.name().equals(UserType.RESTAURANT_OWNER);
        }

    public boolean isCustomer() {
        return this.userType.name().equals(UserType.CUSTOMER);
    }

    //  UPDATE (comportamento)
        public User changeName(String newName) {
            return new User(this.id, newName, this.email, this.userType);
        }

        public User changeEmail(String newEmail) {
            return new User(this.id, this.name, newEmail, this.userType);
        }
    }

