package com.example.car2;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>(List.of(
            new Car("Suzuki", "Swift", 20, Condition.GOOD, new ArrayList<>(List.of(new KmState(LocalDate.of(2000, Month.DECEMBER, 1), 100543),
                    (new KmState(LocalDate.of(2001, Month.DECEMBER, 1), 4004040))))),
            new Car("Opel", "Astra", 13, Condition.GOOD, new ArrayList<>(List.of(new KmState(LocalDate.of(2017, Month.DECEMBER, 1), 50000),
                    (new KmState(LocalDate.of(2020, Month.DECEMBER, 1), 50001)))))));

    public List<Car> getAll() {
    return cars;
    }

    public Set<String> getBrands() {
       // return cars.stream().map(x -> x.getBrand()).distinct().collect(Collectors.toList());
        return cars.stream().map(Car::getBrand).collect(Collectors.toSet());
    }
}
