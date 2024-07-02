package com.example.jwtspringbt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockShipRqDTO {
    private Long barangId;
    private Long shipperId;
    private Integer stock;
    private String tipe;
}
