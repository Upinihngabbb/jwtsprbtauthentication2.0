package com.example.jwtspringbt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@Table(name = "tbl_ship")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long barangId;
    private Long shipperId;
    private Integer stok;
    private String tipe;
    private Date tanggal;
}
