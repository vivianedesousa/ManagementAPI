package com.multirestaurant.managementapi.infrastructure.persistence.repository;
import com.multirestaurant.managementapi.infrastructure.persistence.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<RestaurantEntity,Long> {
}
