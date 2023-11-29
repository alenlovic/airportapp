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
    @Path("/getById/{Id}")
    @Produces("application/json")
    public PassengerDTO getPassengerById(@PathParam("Id")Long Id){return passengerService.getPassengerById(Id);}

    @DELETE
    @Path("/delete/{Id}")
    @Produces("application/json")
    public void deletePassenger(@PathParam("Id")Long passengerId){passengerService.deletePassengerId(passengerId);}

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
    @Path("/update/{Id}")
    @Consumes("application/json")
    public void updatePassenger(@PathParam("Id")Long Id, PassengerUpdateDTO passengerUpdateDTO){
        passengerRepository.updatePassenger(passengerUpdateDTO.getOldFirstName(), passengerUpdateDTO.getNewFirstName(),
                passengerUpdateDTO.getOldLastName(), passengerUpdateDTO.getNewLastName(), passengerUpdateDTO.getOldEmailAddress(),
                passengerUpdateDTO.getNewEmailAddress(), passengerUpdateDTO.getOldPhoneNumber(), passengerUpdateDTO.getNewPhoneNumber());
    }


}
