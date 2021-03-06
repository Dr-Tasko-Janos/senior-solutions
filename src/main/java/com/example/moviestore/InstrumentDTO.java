package com.example.moviestore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentDTO {

    private String brand;
    private InstrumentType type;
    private int price;
    private LocalDate postDate;
}
