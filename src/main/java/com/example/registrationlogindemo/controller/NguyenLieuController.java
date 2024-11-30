package com.example.registrationlogindemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.registrationlogindemo.service.NguyenLieuService;
import com.example.registrationlogindemo.service.TableService;
import com.example.registrationlogindemo.entity.RestaurantTable;
import com.example.registrationlogindemo.entity.NguyenLieu;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/nguyenlieu")
public class NguyenLieuController {
    @Autowired
    private NguyenLieuService nl;

    @PostMapping("/update")
    public ResponseEntity<String> updatenguyenlieu(@RequestBody NguyenLieu nguyenLieu) {
        // if nguyenlieu getname onlny contains whitespace, return alert
        if (nguyenLieu.getDinhluong().trim().length() == 0) return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        // same with des
        if (nguyenLieu.getDes().trim().length() == 0) return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        int ok = nl.update(nguyenLieu);
        if (ok == 1) return ResponseEntity.ok("Cập nhật nguyên liệu thành công");
        return ResponseEntity.badRequest().body("Không tìm thấy nguyên liệu");
    }
}
