package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightUpdateDTO {
    private LocalDateTime oldDepartureTime;
    private LocalDateTime newDepartureTime;
    private LocalDateTime oldArrivalTime;
    private LocalDateTime newArrivalTime;
}
