package com.example.car2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/types")
    public Set<String> getBrands() {
        return carService.getBrands();
    }
}
