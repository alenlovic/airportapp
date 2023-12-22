package org.lova.kafka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.lova.DTO.ReservationCreateDTO;


@ApplicationScoped
public class KafkaReservationProd {

    @Inject
    @Channel("reservation-channel")
    Emitter<ReservationCreateDTO> reservationEmitter;


    public void produceReservation(ReservationCreateDTO reservationDTO) {

        reservationEmitter.send(reservationDTO);
        System.out.println(reservationDTO);
    }
}
