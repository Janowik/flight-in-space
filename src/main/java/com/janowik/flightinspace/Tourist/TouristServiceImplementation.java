package com.janowik.flightinspace.Tourist;

import com.janowik.flightinspace.Model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class TouristServiceImplementation implements TouristService{

    private final TouristRepository touristRepository;

    @Autowired
    public TouristServiceImplementation(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public void saveTourist(@Valid Tourist tourist) {
        touristRepository.save(tourist);

    }

    @Override
    public void deleteTourist(Long id) {
        touristRepository.deleteById(id);
    }

    @Override
    public void updateTourist(Long id, Tourist tourist) {
        Tourist updateTourist = Tourist.builder()
                .id(id)
                .name(tourist.getName())
                .surname(tourist.getSurname())
                .gender(tourist.getGender())
                .country(tourist.getCountry())
                .notes(tourist.getNotes())
                .dateOfBirth(tourist.getDateOfBirth())
                .flight(tourist.getFlight())
                .build();
        touristRepository.save(updateTourist);
    }

    @Override
    public Tourist findTouristById(Long id) {
        return touristRepository.findTouristById(id);
    }
}
