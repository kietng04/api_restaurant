package com.example.registrationlogindemo.service;
import com.example.registrationlogindemo.entity.Staff;
import com.example.registrationlogindemo.repository.StaffRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public int delete(long id) {
        // set isdeleted = 1
        Staff staff = staffRepository.findById(id).orElse(null);
        if (staff != null) {
            staff.setIsdeleted(true);
            staffRepository.save(staff);
            return 1;
        }
        return 0;
    }
    
    @Override   
    public int save(Staff staff) {
        // if id duplicate return 0
        if (staffRepository.findById(staff.getId()).orElse(null) != null) return 0;
        staffRepository.save(staff);
        return 1;
    }

    @Override
    public Staff get(long id) {
        // get staff by id
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public int update(Staff staff) {
        // if id not exist return 0
        if (staffRepository.findById(staff.getId()).orElse(null) == null) return 0;
        staffRepository.save(staff);
        return 1;
    }

    @Override
    public ArrayList<Staff> getAll() {
        // get all staff
        return (ArrayList<Staff>) staffRepository.findAll();
        
    }

}
