package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.ReservationCreateDTO;
import org.lova.DTO.ReservationDTO;
import org.lova.Models.FlightEntity;
import org.lova.Models.PassengerEntity;
import org.lova.Models.ReservationEntity;
import org.lova.Models.TicketEntity;
import org.lova.Repositories.FlightRepository;
import org.lova.Repositories.PassengerRepository;
import org.lova.Repositories.ReservationRepository;
import org.lova.Repositories.TicketRepository;
import org.lova.kafka.KafkaReservationProd;

@ApplicationScoped
public class ReservationService {
    @Inject
    ReservationRepository reservationRepo;
    @Inject
    PassengerRepository passengerRepo;
    @Inject
    FlightRepository flightRepo;
    @Inject
    TicketRepository ticketRepo;

    @Inject
    KafkaReservationProd kafkaReservationProd;

    public void createReservation(ReservationCreateDTO reservationCreateDTO) {
        ReservationEntity reservation = new ReservationEntity();
        FlightEntity flight = flightRepo.getFlightById(reservationCreateDTO.getFlightId());
        PassengerEntity passenger = passengerRepo.getPassengerById(reservationCreateDTO.getPassengerId());

        TicketEntity ticket = new TicketEntity();

        ticket.setFlight(flight);
        ticket.setSeatNumber(reservationCreateDTO.getSeatNumber());
        ticket.setTicketPrice(reservationCreateDTO.getTicketPrice());
        ticket.setPurchaseDate(reservationCreateDTO.getPurchaseDate());
        ticket.setPassenger(passenger);
        ticket.setReservation(reservation);

        reservation.setReservationDateFrom(reservationCreateDTO.getReservationDateFrom());
        reservation.setReservationDateTo(reservationCreateDTO.getReservationDateTo());

        reservationRepo.createReservation(reservation);
        ticketRepo.createTicket(ticket);

        kafkaReservationProd.produceReservation(reservationCreateDTO);
//        KafkaReservationProd sendData = new KafkaReservationProd();
//        sendData.produceReservation(reservationCreateDTO);
    }

    public ReservationDTO getReservationById(Long id) {
        ReservationEntity reservation = reservationRepo.getReservationById(id);
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationDateFrom(reservation.getReservationDateFrom());
        reservationDTO.setReservationDateTo(reservation.getReservationDateTo());
        return reservationDTO;
    }


}
