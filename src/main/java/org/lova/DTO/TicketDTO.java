package org.lova.DTO;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TicketDTO {
    private Long ticketId;
    private String seatNumber;
    private String ticketPrice;
    private Timestamp purchaseDate;
}
