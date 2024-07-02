package com.example.jwtspringbt.controller;


import com.example.jwtspringbt.DTO.StockShipRqDTO;
import com.example.jwtspringbt.model.Stock;
import com.example.jwtspringbt.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class StockController {
    @Autowired
    private StockService stokService;

    @PostMapping("stock")
    public Stock saveStock(@RequestBody StockShipRqDTO req){
        return stokService.addStockShip(req);
    }
}
