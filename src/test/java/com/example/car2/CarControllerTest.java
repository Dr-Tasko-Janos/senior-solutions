package com.example.car2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarControllerTest {

    @Mock
    CarService carService;

    @InjectMocks
    CarController carController;

    @Test
    void getAll() {
List<Car> cars = new ArrayList<>(List.of(
        new Car("Suzuki", "Swift", 20, Condition.GOOD, new ArrayList<>(List.of(new KmState(LocalDate.of(2000, Month.DECEMBER, 1), 100543),
                (new KmState(LocalDate.of(2001, Month.DECEMBER, 1), 4004040))))),
        new Car("Opel", "Astra", 13, Condition.GOOD, new ArrayList<>(List.of(new KmState(LocalDate.of(2017, Month.DECEMBER, 1), 50000),
                (new KmState(LocalDate.of(2020, Month.DECEMBER, 1), 50001)))))));

        when(carService.getAll()).thenReturn(cars);

        List<Car>result = carController.getAll();
        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Opel", "Suzuki");
        verify(carService, times(1)).getAll();
    }

    @Test
    void getBrands() {

        when(carService.getBrands()).thenReturn(Set.of("Suzuki", "Opel"));

        Set<String> result = carController.getBrands();

        assertThat(result)
                .hasSize(2)
                .contains("Suzuki", "Opel");

        verify(carService).getBrands();

    }
}