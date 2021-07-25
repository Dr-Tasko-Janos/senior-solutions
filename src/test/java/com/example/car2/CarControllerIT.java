package com.example.car2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CarControllerIT {

    @Autowired
    CarController carController;

    @Test
    void getAll() {
        List<Car> result = carController.getAll();

        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Suzuki", "Opel");
    }

    @Test
    void getBrands() {
        Set<String> brands = carController.getBrands();

        assertThat(brands)
                .contains("Opel", "Suzuki")
                .hasSize(2);
    }
}
