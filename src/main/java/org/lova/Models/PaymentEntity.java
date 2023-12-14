package org.lova.Models;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "payments")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "payment_id")
    private Long paymentId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntityId;

    @NotNull
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @NotNull
    @Column(name = "payment_amount")
    private String paymentAmount;

    @NotNull
    @Column(name = "payment_method")
    private String paymentMethod;
}
