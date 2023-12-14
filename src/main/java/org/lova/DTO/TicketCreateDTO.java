package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateDTO {
    private String firstName;
    private String lastName;
    private String seatNumber;
    private String ticketPrice;
    private LocalDateTime purchaseDate;
    private Long flightId;
    private LocalDateTime reservationDateFrom;
    private LocalDateTime reservationDateTo;
}
