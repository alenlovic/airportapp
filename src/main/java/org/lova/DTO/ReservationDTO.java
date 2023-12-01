package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.lova.Models.TicketEntity;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Long reservationId;
    private Timestamp reservationDateFrom;
    private Timestamp reservationDateTo;
}
