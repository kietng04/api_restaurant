package com.example.registrationlogindemo.repository;
// extends jpa
import com.example.registrationlogindemo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {

}
