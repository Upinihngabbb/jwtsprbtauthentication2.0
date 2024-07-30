package com.example.jwtspringbt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarangStockData {
    private Long id;
    private String nama;
    private String category;
    private Double berat;
    private String unit; // Added unit field
    private Integer stok;
}