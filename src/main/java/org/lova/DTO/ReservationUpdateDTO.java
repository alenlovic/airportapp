package org.lova.DTO;

import lombok.Data;
import org.lova.Models.TicketEntity;

import java.sql.Timestamp;

@Data
public class ReservationUpdateDTO {
    private Timestamp oldReservationDateFrom;
    private Timestamp newReservationDateFrom;
    private Timestamp oldReservationDateTo;
    private Timestamp newReservationDateTo;
}
