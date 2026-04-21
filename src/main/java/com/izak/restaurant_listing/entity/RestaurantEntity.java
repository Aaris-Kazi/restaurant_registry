package com.izak.restaurant_listing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {
    @Id
    @GeneratedValue(generator = "restaurant_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String description;

}
