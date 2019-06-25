package com.janowik.flightinspace.Flight;

import com.janowik.flightinspace.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
