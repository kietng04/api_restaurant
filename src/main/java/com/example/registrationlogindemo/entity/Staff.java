package com.example.registrationlogindemo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "tb_staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    private Long id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false) 
    private String password;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false, length = 20)
    private String phone;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private boolean isdeleted = false;
    
    @Column(name = "create_time", updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;
    
    @Column(name = "update_time")
    @UpdateTimestamp  
    private LocalDateTime updateTime;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    // role id default = 1
    @Column(name = "role_id", nullable = false)
    private Long roleId = 1L;
}
