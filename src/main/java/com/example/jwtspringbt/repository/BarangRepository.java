package com.example.jwtspringbt.repository;

import com.example.jwtspringbt.DTO.BarangStockData;
import com.example.jwtspringbt.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

    @Query("SELECT new com.example.jwtspringbt.DTO.BarangStockData(b.id, b.nama, b.category, b.berat, b.unit, s.stok) " +
            "FROM Barang b INNER JOIN Stock s ON s.barangId = b.id")
    List<BarangStockData> barangAllWithStock();
}