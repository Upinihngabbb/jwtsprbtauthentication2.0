package com.example.jwtspringbt.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingTractData {
    private String barang;
    private Integer stok;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd, MMM, yyyy  hh:mm")
    private Date tanggal;
    private String tipe;

}
