package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lova.Models.AirlineEntity;
import org.lova.Models.AirportEntity;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Long flightId;
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long airlineId;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

}