package com.example.registrationlogindemo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class StaffDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private boolean isdeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String firstName;
    private String lastName;
    private Long roleId;
}