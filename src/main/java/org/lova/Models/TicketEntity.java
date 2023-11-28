package org.lova.Models;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Table(name = "tickets")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSeq")
    @SequenceGenerator(name = "ticketSeq", sequenceName = "ticket_sequence", initialValue = 1, allocationSize = 1)
    @NotNull
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "passenger_id")
    private PassengerEntity passengerEntityId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntityId;

    @NotNull
    @Column(name = "seat_number")
    private String seatNumber;

    @NotNull
    @Column(name = "ticket_price")
    private String ticketPrice;

    @NotNull
    @Column(name = "purchase_date")
    private Timestamp purchaseDate;
}
