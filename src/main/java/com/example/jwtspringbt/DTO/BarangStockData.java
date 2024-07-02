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
    private Double berat; // Mengubah tipe data berat menjadi Double

    private Integer stok;
}
