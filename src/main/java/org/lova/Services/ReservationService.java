package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.ReservationDTO;
import org.lova.Models.ReservationEntity;
import org.lova.Repositories.ReservationRepository;

@ApplicationScoped
public class ReservationService {
    @Inject
    ReservationRepository repo;

    public void createReservation(ReservationDTO reservationDTO){
        ReservationEntity reservation = new ReservationEntity();
        reservation.setReservationDateFrom(reservation.getReservationDateFrom());
        reservation.setReservationDateTo(reservation.getReservationDateTo());
        repo.createReservation(reservation);
    }

    public ReservationDTO getReservationById(Long id){
        ReservationEntity reservation = repo.getReservationById(id);
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setReservationDateFrom(reservation.getReservationDateFrom());
        reservationDTO.setReservationDateTo(reservation.getReservationDateTo());
        return reservationDTO;
    }





}
