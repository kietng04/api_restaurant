package com.example.registrationlogindemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
@Table(name = "tb_table_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableStatus {
    @Id
    private String id;
    
    @Column(nullable = false, length = 100)
    private String name;
    
    private String description;
    
    @OneToMany(mappedBy = "status")
    private List<RestaurantTable> tables;
}