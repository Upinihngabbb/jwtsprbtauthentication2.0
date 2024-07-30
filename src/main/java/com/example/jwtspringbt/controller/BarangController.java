    package com.example.jwtspringbt.controller;

    import com.example.jwtspringbt.DTO.BarangStockData;
    import com.example.jwtspringbt.model.Barang;
    import com.example.jwtspringbt.model.Ship;
    import com.example.jwtspringbt.service.BarangService;
    import com.example.jwtspringbt.service.ShipService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;


    @RestController
    @RequestMapping("api")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public class BarangController {

        @Autowired
        private BarangService barangService;

        @Autowired
        private ShipService shipService;

        @GetMapping("barang")
        public List<BarangStockData> getAllBarang() {
            return barangService.getAllBarang();
        }

        @PostMapping("barang")
        public Barang saveBarang(@RequestBody Barang barang) {
            return barangService.saveBarang(barang);
        }

        @PutMapping("barang")
        public Barang updateBarang(@RequestBody Barang barang) {
            return barangService.saveBarang(barang);
        }

        @DeleteMapping("barang/{id}")
        public void deleteBarang(@PathVariable Long id) {
            barangService.deleteBarang(id);
        }

        @GetMapping("barang/{id}/ship")
        public List<Ship> getBarangShip(@PathVariable Long id) {
            return shipService.getShipByBarang(id);
        }
    }