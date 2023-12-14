package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCreateDTO {
    private Long passengerId;
    private Long flightId;
    private String seatNumber;
    private String ticketPrice;
    private String paymentMethod;
    private LocalDateTime purchaseDate;
    private LocalDateTime reservationDateFrom;
    private LocalDateTime reservationDateTo;
}
