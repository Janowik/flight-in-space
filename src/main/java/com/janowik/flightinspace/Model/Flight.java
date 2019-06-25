package com.janowik.flightinspace.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flight")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDate;

    @Column(name = "number_of_seat")
    private int numberOfSeat;

    @Column(name = "ticket_price")
    private double ticketPrice;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private List<Tourist> tourists;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Tourist tourist;

}