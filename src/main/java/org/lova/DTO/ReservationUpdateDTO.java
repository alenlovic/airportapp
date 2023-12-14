package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationUpdateDTO {
    private LocalDateTime oldReservationDateFrom;
    private LocalDateTime newReservationDateFrom;
    private LocalDateTime oldReservationDateTo;
    private LocalDateTime newReservationDateTo;
}
