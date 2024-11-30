package com.example.registrationlogindemo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_nguyenlieu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NguyenLieu {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "des")
    private String des;

    @Column(name = "dinhluong", nullable = false)
    private String dinhluong;
}
