package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightUpdateDTO {
    private Timestamp oldDepartureTime;
    private Timestamp newDepartureTime;
    private Timestamp oldArrivalTime;
    private Timestamp newArrivalTime;
}
