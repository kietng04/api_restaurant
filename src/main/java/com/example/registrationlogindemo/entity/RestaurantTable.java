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
import com.example.registrationlogindemo.entity.TableStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {
    @Id
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "des")
    private String des;
    
    @Column(name = "isdeleted", nullable = false)
    private boolean isdeleted = false;
    
    @Column(name = "customer_code", nullable = false)
    private String customerCode;
    
    @ManyToOne
    @JoinColumn(name = "statusid")
    private TableStatus status;
    
    @Column(name = "create_time", updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;
    
    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;
}