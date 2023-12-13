package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateDTO {
    private String firstName;
    private String lastName;
    private String seatNumber;
    private String ticketPrice;
    private Timestamp purchaseDate;
    private Long flightId;
    private Timestamp reservationDateFrom;
    private Timestamp reservationDateTo;
}
