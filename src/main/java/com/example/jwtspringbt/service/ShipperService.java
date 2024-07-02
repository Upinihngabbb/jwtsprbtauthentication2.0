package com.example.jwtspringbt.service;


import com.example.jwtspringbt.DTO.ShippingTractData;
import com.example.jwtspringbt.model.Shipper;
import com.example.jwtspringbt.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipperService {
    @Autowired
    private ShipperRepository shipperRepository;


    @Autowired
    private ShipService shipService;
    public List<Shipper> getAll() {
        return shipperRepository.findAll();
    }

    public Shipper saveShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    public void deleteShipper(Long id) {
        shipperRepository.deleteById(id);
    }



    public List<ShippingTractData> getShipByShipper(Long id) {
        return shipService.findShipByShipper(id);
    }
}
