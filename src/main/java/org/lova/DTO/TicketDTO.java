package org.lova.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDTO {
    private Long ticketId;
    private String seatNumber;
    private String ticketPrice;
    private LocalDateTime purchaseDate;
}
