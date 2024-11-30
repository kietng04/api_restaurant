package com.example.registrationlogindemo.service;
import com.example.registrationlogindemo.entity.Staff;
import com.example.registrationlogindemo.repository.StaffRepository;

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
    
}
