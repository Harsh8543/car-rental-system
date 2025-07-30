package com.example.credential;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CarRentalController {

    private final CarRentalService rentalService = new CarRentalService();

    @GetMapping("/cars")
    public List<Car> getAvailableCars() {
        return rentalService.getAvailableCars();
    }

    @PostMapping("/rent")
    public String rentCar(@RequestBody Map<String, Object> payload) {
        String carId = payload.get("carId").toString();
        String name = payload.get("name").toString();
        int days = Integer.parseInt(payload.get("days").toString());

        return rentalService.rentCar(carId, name, days);
    }

    @PostMapping("/return")
    public String returnCar(@RequestBody Map<String, Object> payload) {
        String carId = payload.get("carId").toString();
        return rentalService.returnCar(carId);
    }
}
