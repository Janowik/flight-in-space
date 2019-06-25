package com.janowik.flightinspace.Flight;

import com.janowik.flightinspace.Model.Flight;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImplementation implements FlightService {

    private final
    FlightRepository flightRepository;

    public FlightServiceImplementation(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void updateFlight(Long id, Flight flight) {
        Flight updateFlight = Flight.builder()
                .id(flight.getId())
                .departureDate(flight.getDepartureDate())
                .arrivalDate(flight.getArrivalDate())
                .numberOfSeat(flight.getNumberOfSeat())
                .ticketPrice(flight.getTicketPrice())
                .tourist(flight.getTourist())
                .build();
        flightRepository.save(updateFlight);
    }

    @Override
    public Flight findFlightById(Long id) {
        return null;
    }
}
