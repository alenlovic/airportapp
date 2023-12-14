package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.TicketCreateDTO;
import org.lova.DTO.TicketDTO;
import org.lova.Models.FlightEntity;
import org.lova.Models.PassengerEntity;
import org.lova.Models.ReservationEntity;
import org.lova.Models.TicketEntity;
import org.lova.Repositories.FlightRepository;
import org.lova.Repositories.PassengerRepository;
import org.lova.Repositories.ReservationRepository;
import org.lova.Repositories.TicketRepository;

import java.util.List;

@ApplicationScoped
public class TicketService {

    @Inject
    PassengerRepository passengerRepository;
    @Inject
    FlightRepository flightRepository;
    @Inject
    ReservationRepository reservationRepository;
    @Inject
    TicketRepository ticketRepository;

    public void createTicket(TicketCreateDTO ticketCreateDTO) {
        TicketEntity ticket = new TicketEntity();
        PassengerEntity passenger = new PassengerEntity();
        ReservationEntity reservation = new ReservationEntity();
        FlightEntity flight = flightRepository.getFlightById(ticketCreateDTO.getFlightId());
        passenger.setFirstName(ticketCreateDTO.getFirstName());
        passenger.setLastName(ticketCreateDTO.getLastName());
        reservation.setReservationDateFrom(ticketCreateDTO.getReservationDateFrom());
        reservation.setReservationDateTo(ticketCreateDTO.getReservationDateTo());
        ticket.setPurchaseDate(ticketCreateDTO.getPurchaseDate());
        ticket.setSeatNumber(ticketCreateDTO.getSeatNumber());
        ticket.setTicketPrice(ticketCreateDTO.getTicketPrice());

        passengerRepository.createPassenger(passenger);
        ticket.setPassenger(passenger);
        ticket.setFlight(flight);
        ticket.setReservation(reservation);
        ticketRepository.createTicket(ticket);
        reservationRepository.createReservation(reservation);
    }

    public TicketDTO getTicketById(Long id) {
        TicketEntity ticket = ticketRepository.getTicketById(id);
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setSeatNumber(ticket.getSeatNumber());
        ticketDTO.setTicketPrice(ticket.getTicketPrice());
        ticketDTO.setPurchaseDate(ticket.getPurchaseDate());
        return ticketDTO;
    }

    public List<TicketCreateDTO> getTicketList() {
        List<TicketEntity> ticketList = ticketRepository.getTicketList();
        return ticketList.stream().map(ticketEntity -> {
            return new TicketCreateDTO(
                    ticketEntity.getPassenger().getFirstName(),
                    ticketEntity.getPassenger().getLastName(),
                    ticketEntity.getSeatNumber(),
                    ticketEntity.getTicketPrice(),
                    ticketEntity.getPurchaseDate(),
                    ticketEntity.getFlight().getFlightId(),
                    ticketEntity.getReservation().getReservationDateFrom(),
                    ticketEntity.getReservation().getReservationDateTo());
        }).toList();
    }
}
