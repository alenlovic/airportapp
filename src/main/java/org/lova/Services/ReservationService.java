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

    public void createReservation(ReservationCreateDTO reservationCreateDTO) {
        ReservationEntity reservation = new ReservationEntity();
        TicketEntity ticket = new TicketEntity();
        PassengerEntity passenger = new PassengerEntity();
        FlightEntity flight = flightRepo.getFlightById(reservationCreateDTO.getFlightId());
        reservation.setReservationDateFrom(reservationCreateDTO.getReservationDateFrom());
        reservation.setReservationDateTo(reservationCreateDTO.getReservationDateTo());
        ticket.setSeatNumber(reservationCreateDTO.getSeatNumber());
        ticket.setTicketPrice(reservationCreateDTO.getTicketPrice());
        ticket.setPurchaseDate(reservationCreateDTO.getPurchaseDate());
        passenger.setFirstName(reservationCreateDTO.getFirstName());
        passenger.setLastName(reservationCreateDTO.getLastName());
        passenger.setEmail(reservationCreateDTO.getEmail());
        passenger.setPhoneNumber(reservationCreateDTO.getPhoneNumber());

        passengerRepo.createPassenger(passenger);
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        ticket.setReservation(reservation);
        ticketRepo.createTicket(ticket);
        reservation.getTickets().add(ticket);
        reservationRepo.createReservation(reservation);
    }

    public ReservationDTO getReservationById(Long id) {
        ReservationEntity reservation = reservationRepo.getReservationById(id);
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationDateFrom(reservation.getReservationDateFrom());
        reservationDTO.setReservationDateTo(reservation.getReservationDateTo());
        return reservationDTO;
    }


}
