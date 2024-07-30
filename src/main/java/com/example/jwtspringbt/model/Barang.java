package com.example.jwtspringbt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nama;
    private String category;
    private Double berat;
    private String unit; // Added unit field
}