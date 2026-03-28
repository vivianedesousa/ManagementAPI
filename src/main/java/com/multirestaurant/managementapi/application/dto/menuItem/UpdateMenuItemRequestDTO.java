package com.multirestaurant.managementapi.application.dto.menuItem;
import java.math.BigDecimal;
public class UpdateMenuItemRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean dineInOnly;
    private String photoPath;

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
}
