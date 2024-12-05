package com.example.registrationlogindemo.service;
import java.util.ArrayList;

import com.example.registrationlogindemo.entity.Staff;

public interface StaffService {
    int delete(long id);
    int save(Staff staff);
    Staff get(long id);
    int update(Staff staff);
    ArrayList<Staff> getAll();
}

