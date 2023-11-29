package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.PassengerDTO;
import org.lova.DTO.PassengerUpdateDTO;
import org.lova.Repositories.PassengerRepository;
import org.lova.Services.PassengerService;

@ApplicationScoped
@Path("/passenger")
@Transactional
public class PassengerResource {

    @Inject
    PassengerService passengerService;
    @Inject
    PassengerRepository passengerRepository;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createPassenger(PassengerDTO passengerDTO){ passengerService.createPassenger(passengerDTO);}

    @GET
    @Path("/getById/{id}")
    @Produces("application/json")
    public PassengerDTO getPassengerById(@PathParam("id")Long id){return passengerService.getPassengerById(id);}

    @DELETE
    @Path("/delete/{id}")
    @Produces("application/json")
    public void deletePassenger(@PathParam("id")Long passengerId){passengerService.deletePassengerId(passengerId);}

    @GET
    @Path("/getByFirstName/{firstName}")
    @Produces("application/json")
    public PassengerDTO getPassengerByFirstName(@PathParam("firstName")String firstName){
        return passengerService.getPassengerByFirstName(firstName);
    }

    @GET
    @Path("/getByEmailAddress/{email}")
    @Produces("application/json")
    public PassengerDTO getPassengerByEmailAddress(@PathParam("email")String email){
        return passengerService.getPassengerByEmailAddress(email);
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public void updatePassenger(@PathParam("id")Long id, PassengerUpdateDTO passengerUpdateDTO){
        passengerRepository.updatePassenger(id, passengerUpdateDTO);
    }


}
