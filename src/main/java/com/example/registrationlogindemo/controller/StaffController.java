package com.example.registrationlogindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.registrationlogindemo.service.StaffService;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/delete")
    public ResponseEntity<String> deleteStaff(@RequestBody long id) {
        int ok = staffService.delete(id);
        if (ok == 1) return ResponseEntity.ok("Xóa nhân viên thành công");
        return ResponseEntity.badRequest().body("Không tìm thấy nhân viên");
    }
}
