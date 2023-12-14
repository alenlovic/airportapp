package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Long flightId;
    private Long departureAirportId;
    private Long arrivalAirportId;
    private Long airlineId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}