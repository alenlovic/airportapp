package org.lova.Resources;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.AirlineUpdateDTO;
import org.lova.DTO.AirlinesDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Repositories.AirlinesRepository;
import org.lova.Services.AirlinesService;

import java.util.List;

@ApplicationScoped
@Path("/airline")
@Transactional
public class AirlinesResource {

    @Inject
    AirlinesService airlinesService;
    @Inject
    AirlinesRepository airlinesRepository;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createAirlines(AirlinesDTO airlinesDTO) {
        airlinesService.createAirline(airlinesDTO);
    }

    @GET
    @Path("/getById/{Id}")
    @Produces("application/json")
    public AirlinesDTO getById(@PathParam("Id") Long airlineId) {
        return airlinesService.getAirlineById(airlineId);
    }

    @DELETE
    @Path("/delete/{Id}")
    @Produces("application/json")
    public void deleteAirline(@PathParam("Id") Long airlineId) {
        airlinesService.deleteAirline(airlineId);
    }

    @GET
    @Path("/getByName/{airlineName}")
    @Produces("application/json")
    public AirlinesDTO getByName(@PathParam("airlineName") String airlineName) {
        return airlinesService.getAirlineByName(airlineName);
    }

    @PUT
    @Path("/update/{Id}")
    @Consumes("application/json")
    public void updateAirline(@PathParam("Id") Long Id, AirlineUpdateDTO airlineUpdateDTO) {
        airlinesRepository.updateAirline(airlineUpdateDTO.getOldName(),
                                         airlineUpdateDTO.getNewName());
    }

    @GET
    @Path("/getList")
    @Produces("application/json")
    public List<AirlinesDTO> getAirlinesList() {
        return airlinesService.getAirlinesList();
    }


}
