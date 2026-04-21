package com.izak.restaurant_listing.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.izak.restaurant_listing.entity.RestaurantEntity;


@Repository
public interface RestaurantRepo extends JpaRepository<RestaurantEntity, Long> {
    
    @Query("Select r from RestaurantEntity r where r.id = ?1")
    public Optional<RestaurantEntity> findById(Long id);
}
