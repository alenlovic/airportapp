package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Long reservationId;
    private LocalDateTime reservationDateFrom;
    private LocalDateTime reservationDateTo;
}
