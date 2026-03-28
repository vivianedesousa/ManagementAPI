package com.multirestaurant.managementapi.infrastructure.persistence.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
//"As entidades utilizam getters e setters para permitir " +
//"a manipulação de dados pelo JPA, diferentemente do domínio.

@Entity
@Table(name = "menu_items")
  public class MenuItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "dine_in_only")
    private boolean dineInOnly;

    @Column(name = "photo_path", length = 250)
    private String photoPath;

    // RELACIONAMENTO COM RESTAURANT
    @ManyToOne
    @JoinColumn(
            name = "restaurant_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_menu_items_restaurant")
    )
    private RestaurantEntity restaurant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isDineInOnly() {
        return dineInOnly;
    }

    public void setDineInOnly(boolean dineInOnly) {
        this.dineInOnly = dineInOnly;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
}

