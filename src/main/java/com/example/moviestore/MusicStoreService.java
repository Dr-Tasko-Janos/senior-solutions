package com.example.moviestore;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

@Service
public class MusicStoreService {

    private ModelMapper modelMapper;

    public MusicStoreService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    private List<Instrument> instruments = Collections.synchronizedList(new ArrayList<>());

    AtomicLong idGenerator = new AtomicLong();

    public Instrument findInstrumentById( long id) {
      Instrument instrumentFoundById = instruments.stream().filter(e -> e.getId() == id).findFirst().orElseThrow(() -> new IllegalArgumentException("Not found Instrument with id: " + id));
      return instrumentFoundById;
    }

    public List<InstrumentDTO> getInstruments(Optional<String> brand, Optional<Integer> price) {

        Type returnListType = new TypeToken<List<InstrumentDTO>>(){}.getType();

        List<Instrument> filteredInstruments = instruments.stream()
                .filter(e -> brand.isEmpty() || e.getBrand().equals(brand.get()))
                .filter(e -> price.isEmpty() || e.getPrice() == price.get())
                .collect(Collectors.toList());
        return modelMapper.map(filteredInstruments, returnListType);
    }

    public InstrumentDTO createInstrument(CreateInstrumentCommand command) {
        Instrument newInstrument = new Instrument(idGenerator.incrementAndGet(), command.getBrand(), command.getInstrumentType(), command.getPrice(), now());
        instruments.add(newInstrument);
        return modelMapper.map(newInstrument, InstrumentDTO.class);
    }

    public void deleteAll() {
        instruments.clear();
        idGenerator = new AtomicLong();
    }

    public InstrumentDTO updatePrice(long id, UpdatePriceCommand command) {
        Instrument updateInstrument = findInstrumentById(id);
        if (updateInstrument.getPrice() != command.getPrice()) {
            updateInstrument.setPrice(command.getPrice());
            updateInstrument.setPostDate(LocalDate.now());
        }
        return modelMapper.map(updateInstrument, InstrumentDTO.class);
    }

    public void deleteInstrumentById(long id) {
        Instrument instrumentToDelete = findInstrumentById(id);
        instruments.remove(instrumentToDelete);
    }
}
