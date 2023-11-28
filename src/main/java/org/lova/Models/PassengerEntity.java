package org.lova.Models;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "passengers")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengerSeq")
    @SequenceGenerator(name = "passengerSeq", sequenceName = "passenger_sequence",initialValue = 1, allocationSize = 1)
    @Column(name = "passenger_id")
    private Long passengerId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;
}
