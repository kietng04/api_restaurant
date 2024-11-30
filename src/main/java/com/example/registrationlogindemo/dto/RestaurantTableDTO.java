package com.example.registrationlogindemo.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class RestaurantTableDTO {
    private Long id;
    private String name;
    private String des;
    private boolean isdeleted;
    private String customerCode;
    private String statusId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}