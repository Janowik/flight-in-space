package com.janowik.flightinspace.Tourist;

import com.janowik.flightinspace.Model.Tourist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/tourists")
public class TouristController {

    private final
    TouristRepository touristRepository;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @GetMapping
    List<Tourist> getAllTourist(){
        return touristRepository.findAll();
    }

    @PostMapping
    ResponseEntity saveTourist(@Valid Tourist tourist){
        touristRepository.save(tourist);
        return new ResponseEntity(HttpStatus.OK);
    }
}