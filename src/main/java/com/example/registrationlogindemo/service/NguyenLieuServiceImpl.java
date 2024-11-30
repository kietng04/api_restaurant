package com.example.registrationlogindemo.service;
import com.example.registrationlogindemo.entity.Staff;
import com.example.registrationlogindemo.repository.NguyenLieuRepository;
import com.example.registrationlogindemo.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Service;
import com.example.registrationlogindemo.entity.NguyenLieu;

@Service
public class NguyenLieuServiceImpl implements NguyenLieuService {
    @Autowired
    NguyenLieuRepository nguyenLieuRepository;
    
    @Override
    public int update(NguyenLieu nguyenLieu) {
        int res = 0;
        if (nguyenLieu.getId() != null) {
            NguyenLieu nl = nguyenLieuRepository.findById(nguyenLieu.getId()).orElse(null);
            if (nl != null) {
                nl.setName(nguyenLieu.getName());
                nl.setDes(nguyenLieu.getDes());
                nl.setDinhluong(nguyenLieu.getDinhluong());
                nguyenLieuRepository.save(nl);
                res = 1;
            }
        }
        return res;
    }
}
