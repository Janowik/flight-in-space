package com.janowik.flightinspace.Flight;

import com.janowik.flightinspace.Model.Flight;
import org.springframework.stereotype.Service;

@Service("flightService")
public interface FlightService {
    void saveFlight(Flight flight);
    void deleteFlight(Long id);
    void updateFlight(Long id, Flight flight);
    Flight findFlightById(Long id);
}
