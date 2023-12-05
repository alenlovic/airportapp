package org.lova.DTO;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;

@Data
public class FlightDTO {
    private Long flightId;
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long airlineId;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
}
