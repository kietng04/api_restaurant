package com.example.registrationlogindemo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.registrationlogindemo.service.StaffService;
import com.example.registrationlogindemo.entity.Staff;
// import getmappjng
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable long id) {
        int ok = staffService.delete(id);
        if (ok == 1) return ResponseEntity.ok("Xóa nhân viên thành công");
        return ResponseEntity.badRequest().body("Không tìm thấy nhân viên");
    }

    // get mapping nhanvien base on id
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getStaff(@PathVariable long id) {
        Staff staff = staffService.get(id);
        
        if (staff == null) return ResponseEntity.badRequest().body("Không tìm thấy nhân viên");
        return ResponseEntity.ok(staff);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveStaff(@RequestBody Staff staff) {
        if (staff.getUsername().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getPhone().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getAddress().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getRoleId() == "") 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        // username duplicate ? 
        ArrayList<Staff> staffs = staffService.getAll();
        for (Staff s : staffs) {
            if (s.getUsername().equals(staff.getUsername())) 
                return ResponseEntity.badRequest().body("Tên đăng nhập đã tồn tại");
        }
        // length of so dien thoai must be 10 start with 0
        if (staff.getPhone().length() != 10 || staff.getPhone().charAt(0) != '0') 
            return ResponseEntity.badRequest().body("Số điện thoại không hợp lệ vui lòng nhập 10 số và bắt đầu bằng số 0");
        // regex only number a-z A-Z 0-9 con tain @gmail.com
        if (!staff.getEmail().matches("^[a-zA-Z0-9]+@gmail.com$")) 
            return ResponseEntity.badRequest().body("Email không hợp lệ vui lòng nhập đúng định dạng");
        int ok = staffService.save(staff);
        if (ok == 1) return ResponseEntity.ok("Thêm nhân viên thành công");
        return ResponseEntity.badRequest().body("ID Nhân viên đã tồn tại");
    }

    // put mapping update staff
    @PutMapping("/update")
    public ResponseEntity<String> updateStaff(@RequestBody Staff staff) {
        if (staff.getId() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getUsername().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getPhone().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getAddress().trim().length() == 0) 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");
        if (staff.getRoleId() == "") 
            return ResponseEntity.badRequest().body("Vui lòng nhập đầy đủ thông tin");

        // length of so dien thoai must be 10 start with 0
        if (staff.getPhone().length() != 10 || staff.getPhone().charAt(0) != '0') 
            return ResponseEntity.badRequest().body("Số điện thoại không hợp lệ vui lòng nhập 10 số và bắt đầu bằng số 0");
        // regex only number a-z A-Z 0-9 con tain @gmail.com
        if (!staff.getEmail().matches("^[a-zA-Z0-9]+@gmail.com$")) 
            return ResponseEntity.badRequest().body("Email không hợp lệ vui lòng nhập đúng định dạng");
        int ok = staffService.update(staff);
        if (ok == 1) return ResponseEntity.ok("Cập nhật nhân viên thành công");
        return ResponseEntity.badRequest().body("Không tìm thấy nhân viên");
    }
}
