package com.izak.restaurant_listing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.izak.restaurant_listing.DTOs.RestaurantDTO;
import com.izak.restaurant_listing.entity.RestaurantEntity;
import com.izak.restaurant_listing.mappers.RestaurantMappers;
import com.izak.restaurant_listing.repositories.RestaurantRepo;
import com.izak.restaurant_listing.request.RestaurantRequest;

@Service
public class RestaurantServices {

    private final RestaurantRepo restaurantRepo;

    public RestaurantServices(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantEntity> restaurantData = restaurantRepo.findAll();

        return restaurantData
                .stream()
                .map(res -> RestaurantMappers.INSTANCE.toDTO(res))
                .toList();
    }

    public RestaurantDTO getRestaurantById(Long id) {
        // Implementation for fetching a restaurant by ID

        Optional<RestaurantEntity> restaurant = restaurantRepo.findById(id);
        return restaurant.map(RestaurantMappers.INSTANCE::toDTO).orElse(null);
    }

    public RestaurantDTO addRestaurant(RestaurantRequest restaurantRequest) {
        // Implementation for adding a restaurant

        RestaurantEntity restaurantEntity = RestaurantMappers.INSTANCE.toEntity(restaurantRequest);
        RestaurantEntity savedRestaurant = restaurantRepo.save(restaurantEntity);
        return RestaurantMappers.INSTANCE.toDTO(savedRestaurant);
    }

}
