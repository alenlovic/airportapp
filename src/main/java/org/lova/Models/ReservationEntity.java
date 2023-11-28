package org.lova.Models;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Table(name = "reservations")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationSeq")
    @SequenceGenerator(name = "reservationSeq", sequenceName = "reservation_sequence", initialValue = 1, allocationSize = 1)
    @NotNull
    @Column(name = "reservation_id")
    private Long reservationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntityId;

    @NotNull
    @Column(name = "reservation_date_from")
    private Timestamp reservationDateFrom;

    @NotNull
    @Column(name = "reservation_date_to")
    private Timestamp reservationDateTo;
}
