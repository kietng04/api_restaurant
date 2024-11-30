package com.example.registrationlogindemo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.registrationlogindemo.dto.RestaurantTableDTO;
import com.example.registrationlogindemo.repository.TableRepository;
import com.example.registrationlogindemo.entity.RestaurantTable;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableRepository tableRepository;

    @Override
    public int updateTable(RestaurantTable restaurantTable) {
        int res = 0;
        if (restaurantTable.getId() != null) {
            RestaurantTable table = tableRepository.findById(restaurantTable.getId()).orElse(null);
            if (table != null) {
                table.setIsdeleted(restaurantTable.isIsdeleted());
                table.setName(restaurantTable.getName());
                table.setDes(restaurantTable.getDes());
                table.setCustomerCode(restaurantTable.getCustomerCode());
                table.setStatus(restaurantTable.getStatus());
                tableRepository.save(table);
                res = 1;
            }
        }
        return res;
    }
    
}
