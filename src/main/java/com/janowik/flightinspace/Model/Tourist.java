package com.janowik.flightinspace.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tourist")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull
    @Column(name = "country")
    private String country;


    @Column(name = "notes")
    private String notes;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Flight flight;

    @OneToMany(mappedBy = "tourist", fetch = FetchType.LAZY)
    private List<Flight> flights;
}
