package com.example.registrationlogindemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.registrationlogindemo.service.TableService;
import com.example.registrationlogindemo.entity.RestaurantTable;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/table")
public class RestaurantTableController {
    @Autowired
    private TableService tableService;

    @PostMapping("/update")
    public ResponseEntity<String> updateTable(@RequestBody RestaurantTable restaurantTable) {
        // if restaurant des is empty
        if (restaurantTable.getDes().trim().length() == 0) return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        int ok = tableService.updateTable(restaurantTable);
        if (ok == 1) return ResponseEntity.ok("Cập nhật bàn thành công");
        return ResponseEntity.badRequest().body("Không tìm thấy bàn");
    }
}
