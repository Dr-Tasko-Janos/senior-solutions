package com.example.moviestore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instrument {

    private long id;
    @NotEmpty
    private String brand;
    private InstrumentType type;
    @PositiveOrZero
    private int price;
    private LocalDate postDate;
}
