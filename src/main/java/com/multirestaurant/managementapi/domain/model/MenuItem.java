package com.multirestaurant.managementapi.domain.model;
import com.multirestaurant.managementapi.domain.exception.menuItem.InvalidProductException;
import java.math.BigDecimal;
//Restaurant 1 → N MenuItem //
//ele  cadastrar  um cardpio

//public class MenuItem {
//    private final Long id;
//    private final String name;
//    private final String description;
//    private final BigDecimal price;
//    private final boolean dineInOnly;
//    private final String photoPath;
//    private final Restaurant restaurant;
//    private final   boolean delivery;
//    public MenuItem(Long id,
//                    String name,
//                    String description,
//                    BigDecimal price,
//                    boolean dineInOnly,
//                    boolean delivery;
//                    String photoPath,
//                    Restaurant restaurant) {
//        validate(name, price, restaurant);
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.dineInOnly = dineInOnly;
//        this. delivery= delivery;
//        this.photoPath = photoPath;
//        this.restaurant = restaurant;
//    }
//
//    public void  validate(String name, BigDecimal price, Restaurant restaurant) {
//        if (name == null || name.isBlank()) {
//            throw new InvalidProductException("Name is required");
//        }
//
//        if (price == null || price.doubleValue() <= 0) {
//            throw new InvalidProductException("Price must be greater than zero");
//        }
//
//        if (restaurant == null) {
//            throw new InvalidProductException("Restaurant is required");
//        }
//
//        public void validateOrder(Boolean dineInOnly) {
//            if (this.dineInOnly && ) {
//                throw new InvalidProductException(
//                        "Item disponível apenas no restaurante"
//                );
//            }
//        }
//
//    }
//        public Long identity () {
//            return id;
//        }
//        public String name () {
//            return name;
//        }
//        public String description () {
//            return description;
//        }
//        public BigDecimal price () {
//            return price;
//        }
//        public boolean dineInOnly () {
//            return dineInOnly;
//        }
//        public String photoPath () {
//            return photoPath;
//        }
//        public Restaurant restaurant () {
//            return restaurant;
//    }
//}
    public class MenuItem {
        private final Long id;
        private final String name;
        private final String description;
        private final BigDecimal price;
        private final boolean dineInOnly;
        private final String photoPath;
        private final Restaurant restaurant;
        public MenuItem(Long id,
                        String name,
                        String description,
                        BigDecimal price,
                        boolean dineInOnly,
                        String photoPath,
                        Restaurant restaurant) {

            validate(name, price, restaurant);

            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.dineInOnly = dineInOnly;
            this.photoPath = photoPath;
            this.restaurant = restaurant;
        }

        // validações básicas
        private void validate(String name, BigDecimal price, Restaurant restaurant) {
            if (name == null || name.isBlank()) {
                throw new InvalidProductException("Name is required");
            }

            if (price == null || price.doubleValue() <= 0) {
                throw new InvalidProductException("Price must be greater than zero");
            }

            if (restaurant == null) {
                throw new InvalidProductException("Restaurant is required");
            }
        }

        // regra opcional (não usada agora)
        public void validateOrder(boolean delivery) {
            if (this.dineInOnly && delivery) {
                throw new InvalidProductException(
                        "Item disponível apenas no restaurante"
                );
            }
        }

        // getters
        public Long identity() {
            return id;
        }

        public String name() {
            return name;
        }

        public String description() {
            return description;
        }

        public BigDecimal price() {
            return price;
        }

        public boolean dineInOnly() {
            return dineInOnly;
        }

        public String photoPath() {
            return photoPath;
        }

        public Restaurant restaurant() {
            return restaurant;
        }
    }


