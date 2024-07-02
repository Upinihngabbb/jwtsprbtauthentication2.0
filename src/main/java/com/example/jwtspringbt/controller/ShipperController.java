package com.example.jwtspringbt.controller;

import com.example.jwtspringbt.DTO.ShippingTractData;
import com.example.jwtspringbt.model.Shipper;
import com.example.jwtspringbt.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping("shipper")
    public List<Shipper> getAll() {
        return shipperService.getAll();
    }

    @PostMapping("shipper")
    public Shipper saveShipper(@RequestBody Shipper shipper) {
        return shipperService.saveShipper(shipper);
    }

    @PutMapping("shipper")
    public Shipper updateShipper(@RequestBody Shipper shipper) {
        return shipperService.saveShipper(shipper);
    }

    @DeleteMapping("shipper/{id}")
    public void deleteShipper(@PathVariable Long id) {
        shipperService.deleteShipper(id);
    }

    @GetMapping("shipper/{id}/shipping")
    public List<ShippingTractData> getShipShipper(@PathVariable Long id) {
        return shipperService.getShipByShipper(id);
    }

}