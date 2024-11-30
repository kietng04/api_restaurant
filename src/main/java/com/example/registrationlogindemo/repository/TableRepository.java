package com.example.registrationlogindemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registrationlogindemo.entity.RestaurantTable;

public interface TableRepository extends JpaRepository<RestaurantTable, Long> {

}
