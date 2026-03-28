package com.multirestaurant.managementapi.application.mapper.dto;
import com.multirestaurant.managementapi.application.dto.menuItem.MenuItemResponseDTO;
import com.multirestaurant.managementapi.domain.model.MenuItem;
import org.springframework.stereotype.Component;

@Component
public class MenuItemResponseMapperDTO {
   public MenuItemResponseDTO toResponse(MenuItem menuItem) {
       String message = menuItem.dineInOnly()
               ? "Disponível apenas para consumo no local"
               : "Disponível para delivery e consumo no local";
     return new MenuItemResponseDTO(
       menuItem.identity(),
       menuItem.name(),
       menuItem.description(),
       menuItem.price(),
       menuItem.dineInOnly(),
       menuItem.photoPath(),
       message
     );
   }
 }
