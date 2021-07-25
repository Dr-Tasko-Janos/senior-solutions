package com.example.moviestore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstrumentCommand {
@NotBlank(message="Name cannot be blank")
    private String brand;

    private InstrumentType instrumentType;
@Positive
    private int price;
}
