package com.janowik.flightinspace.Flight;

import com.janowik.flightinspace.Model.Flight;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.datatransfer.FlavorListener;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/flights")
public class FlightController {

    private final
    FlightService flightService;

    private final
    FlightRepository flightRepository;

    @Autowired
    public FlightController(FlightService flightService, FlightRepository flightRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public ResponseEntity getAllFlights() throws NotFoundException {
        List<Flight> flights = flightRepository.findAll();
        if (flights.isEmpty()){
            throw new NotFoundException("Not found any flights");
        }else {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable("id") long id) throws NotFoundException {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()){
            return new ResponseEntity<>(flight, HttpStatus.OK);
        }else {
            throw new NotFoundException("Not found flights with ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@Valid Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Flight> deleteFlightById(@PathVariable("id") long id) throws NotFoundException {
        Optional<Flight> flightExist = flightRepository.findById(id);
        if (flightExist.isPresent()){
            flightService.deleteFlight(id);
        }else {
            throw new NotFoundException("Not found flight with ID:" + id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateFlight(@Valid Flight flight) throws NotFoundException {
        Optional<Flight> updateFlight = flightRepository.findById(flight.getId());
        if (updateFlight.isPresent()){
            Flight updateOldFlight = Flight.builder()
                    .id(flight.getId())
                    .departureDate(flight.getDepartureDate())
                    .arrivalDate(flight.getArrivalDate())
                    .numberOfSeat(flight.getNumberOfSeat())
                    .ticketPrice(flight.getTicketPrice())
                    //.tourist(flight.getTourist())
                    .build();
            flightRepository.save(updateOldFlight);
        }else {
            throw new NotFoundException("Not found flight to update.");
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
