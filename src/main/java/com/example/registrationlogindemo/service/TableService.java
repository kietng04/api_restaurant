package com.example.registrationlogindemo.service;
import com.example.registrationlogindemo.dto.RestaurantTableDTO;
import com.example.registrationlogindemo.entity.RestaurantTable;
import com.example.registrationlogindemo.entity.Staff;

public interface TableService {
    int updateTable(RestaurantTable restaurantTable);
}

