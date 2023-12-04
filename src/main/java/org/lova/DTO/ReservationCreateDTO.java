package org.lova.DTO;

import lombok.Data;
import org.lova.Models.FlightEntity;

import java.sql.Timestamp;

@Data
public class ReservationCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String seatNumber;
    private String ticketPrice;
    private String paymentMethod;
    private Timestamp purchaseDate;
    private Long flightId;
    private Timestamp reservationDateFrom;
    private Timestamp reservationDateTo;
}
