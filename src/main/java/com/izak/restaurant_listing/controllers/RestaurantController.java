package com.izak.restaurant_listing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.izak.restaurant_listing.DTOs.RestaurantDTO;
import com.izak.restaurant_listing.request.RestaurantRequest;
import com.izak.restaurant_listing.services.RestaurantServices;

import jakarta.validation.Valid;

import java.util.List;
import java.util.logging.Logger;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantServices restaurantServices;
    private static final Logger logger = Logger.getLogger(RestaurantController.class.getName());

    public RestaurantController(RestaurantServices restaurantServices) {
        this.restaurantServices = restaurantServices;
    }



    @GetMapping("/")
    public String getRstaurants() {
        return "Hello World";
    }

    @GetMapping("/all")
    public ResponseEntity<List<RestaurantDTO>> fetchAll() {
        try {       
            logger.info("Fetching all restaurants...");
            return ResponseEntity.ok(restaurantServices.getAllRestaurants());
        } catch (Exception e) {
            System.out.println("Error fetching restaurants: " + e.getMessage());
            logger.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody @Valid RestaurantRequest restaurantRequest) {

        try {
            RestaurantDTO addedRestaurant = restaurantServices.addRestaurant(restaurantRequest);
            return ResponseEntity.status(HttpStatus.SC_CREATED).body(addedRestaurant);
            
        } catch (Exception e) {
            System.out.println("Error adding restaurant: " + e.getMessage());
            logger.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Long id) {
        RestaurantDTO restaurant = restaurantServices.getRestaurantById(id);
        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurant);
    }
    
    
    

}
