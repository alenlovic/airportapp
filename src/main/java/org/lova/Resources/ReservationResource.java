package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.ReservationCreateDTO;
import org.lova.DTO.ReservationDTO;
import org.lova.DTO.ReservationUpdateDTO;
import org.lova.Repositories.ReservationRepository;
import org.lova.Services.ReservationService;

@ApplicationScoped
@Path("/reservation")
@Transactional
public class ReservationResource {

    @Inject
    ReservationService reservationService;
    @Inject
    ReservationRepository reservationRepository;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createReservation(ReservationCreateDTO reservationCreateDTO){reservationService.createReservation(reservationCreateDTO);}

    @GET
    @Path("/getById/{id}")
    @Produces("application/json")
    public ReservationDTO getReservationById(@PathParam("id") Long id){return reservationService.getReservationById(id);}

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public void updateReservation(@PathParam("id")Long id, ReservationUpdateDTO reservationUpdateDTO){
        reservationRepository.updateReservation(id, reservationUpdateDTO);
    }
}
