package com.izak.restaurant_listing.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {

    private Long id;
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String address;
    @NotNull(message = "City is required")
    @NotEmpty(message = "City cannot be empty")
    private String city;
    private String description;
    

    
}
