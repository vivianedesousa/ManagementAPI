package com.multirestaurant.managementapi.application.dto.menuItem;
import java.math.BigDecimal;
public class MenuItemResponseDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean dineInOnly;
    private String photoPath;
    private String message;

    public MenuItemResponseDTO(Long id,
                               String name,
                               String description,
                               BigDecimal price,
                               boolean dineInOnly,
                               String photoPath,
                               String message
                               ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dineInOnly = dineInOnly;
        this.photoPath = photoPath;
        this.message = message;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public boolean isDineInOnly() {
        return dineInOnly;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public String getMessage() { // ✅ GETTER NOVO
        return message;
    }

}
