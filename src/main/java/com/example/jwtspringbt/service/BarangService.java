package com.example.jwtspringbt.service;

import com.example.jwtspringbt.DTO.BarangStockData;
import com.example.jwtspringbt.model.Barang;
import com.example.jwtspringbt.model.Stock;
import com.example.jwtspringbt.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BarangService {
    @Autowired
    private BarangRepository barangRepository;

    @Autowired
    private StockService stokService;

    public List<BarangStockData> getAllBarang() {
        return barangRepository.barangAllWithStock();
    }

    public Barang saveBarang(Barang barang) {
        boolean isCreated = false;
        if (Objects.isNull(barang.getId())) {
            isCreated = true;
        }
        barang = barangRepository.save(barang);

        if (isCreated) {
            Stock stok = Stock.builder()
                    .barangId(barang.getId())
                    .stok(0)
                    .build();

            stokService.saveStok(stok);
        }
        return barang;
    }

    public void deleteBarang(Long id) {
        Optional<Barang> barangOpt = barangRepository.findById(id);
        if (!barangOpt.isPresent()) {
            throw new RuntimeException("Barang tidak ditemukan");
        }
        stokService.deleteStokByBarang(id);
        barangRepository.deleteById(id);
    }
}