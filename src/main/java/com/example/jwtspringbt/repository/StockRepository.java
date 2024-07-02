package com.example.jwtspringbt.repository;


import com.example.jwtspringbt.model.Stock;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Long> {
    void deleteByBarangId(Long id);
    Optional<Stock> findByBarangId(Long barangId);
}
