package com.izak.restaurant_listing.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.izak.restaurant_listing.DTOs.RestaurantDTO;
import com.izak.restaurant_listing.entity.RestaurantEntity;
import com.izak.restaurant_listing.request.RestaurantRequest;

@Mapper
public interface RestaurantMappers {
    RestaurantMappers INSTANCE = Mappers.getMapper(RestaurantMappers.class);

    RestaurantEntity toEntity(RestaurantDTO restaurantDTO);
    RestaurantEntity toEntity(RestaurantRequest restaurantRequest);
    RestaurantDTO toDTO(RestaurantEntity restaurantEntity);
}
