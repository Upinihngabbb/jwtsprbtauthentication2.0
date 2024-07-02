package com.example.jwtspringbt.service;

import com.example.jwtspringbt.DTO.ShippingTractData;
import com.example.jwtspringbt.model.Ship;
import com.example.jwtspringbt.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    @Autowired
    private ShipRepository shipRepository;

    public List<Ship> getShipByBarang(Long id){
        return shipRepository.findByBarangId(id);
    }

    public List<ShippingTractData> findShipByShipper(Long id) {
        return shipRepository.findByTrackShipperId(id);
    }
}
