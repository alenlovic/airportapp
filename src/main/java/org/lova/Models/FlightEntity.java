package org.lova.Models;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Table(name = "flights")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSeq")
    @SequenceGenerator(name = "flightSeq", sequenceName = "flight_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "flight_id")
    private Long flightId;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private AirportEntity departureAirportEntity;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private AirportEntity arrivalAirportEntity;

    @NotNull
    @Column(name = "departure_time")
    private Timestamp departureTime;

    @NotNull
    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airlineEntityId;

}




