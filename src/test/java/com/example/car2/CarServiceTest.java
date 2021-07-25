package com.example.car2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void getAll() {
    List<Car> result = carService.getAll();
       assertThat(result)
            .hasSize(2)
            .extracting(Car::getBrand)
            .contains("Suzuki", "Opel");
    }

    @Test
    void getBrands() {
        Set<String> brands = carService.getBrands();

        assertThat(brands)
                .contains("Suzuki", "Opel")
                .hasSize(2)
        ;

    }
}