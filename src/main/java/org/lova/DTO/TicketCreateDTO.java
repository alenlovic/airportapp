package org.lova.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
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
