package com.multirestaurant.managementapi.domain.model;
import com.multirestaurant.managementapi.domain.exception.restaurant.InvalidRestaurantException;
public class Restaurant {
        private final Long id;
        private final String name;
        private final String address;
        private final String cuisineType;
        private final String openingHours;
        private final User owner;
        public Restaurant(Long id,
                          String name,
                          String address,
                          String cuisineType,
                          String openingHours,
                          User owner) {
            validate(name, address, cuisineType, openingHours, owner);
            this.id = id;
            this.name = name;
            this.address = address;
            this.cuisineType = cuisineType;
            this.openingHours = openingHours;
            this.owner = owner;
        }

        // REGRAS DE NEGÓCIO
        private void validate(String name,
                              String address,
                              String cuisineType,
                              String openingHours,
                              User owner) {
            if (name == null || name.isBlank()) {
                throw new InvalidRestaurantException("Name is required");
            }

            if (address == null || address.isBlank()) {
                throw new InvalidRestaurantException("Address is required");
            }

            if (cuisineType == null || cuisineType.isBlank()) {
                throw new InvalidRestaurantException("Cuisine type is required");
            }

            if (openingHours == null || openingHours.isBlank()) {
                throw new InvalidRestaurantException("Opening hours is required");
            }

            if (owner == null) {
                throw new InvalidRestaurantException("Owner is required");
            }

            //  REGRA MAIS IMPORTANTE DO SISTEMA
            if (!owner.isRestaurantOwner()) {
                throw new InvalidRestaurantException("User is not restaurant owner");
            }
        }

        public Long identity() {
            return id;
        }

        public String name() {
            return name;
        }

        public String address() {
            return address;
        }

        public String cuisineType() {
            return cuisineType;
        }

        public String openingHours() {
            return openingHours;
        }

        public User owner() {
            return owner;
        }
}
