package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.AirportDTO;
import org.lova.Services.AirportService;

@Path("/airport")
@Transactional
@ApplicationScoped
public class AirportResource {
    @Inject
    AirportService airportService;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createAirport(AirportDTO airportDTO){ airportService.createAirport(airportDTO);}

    @GET
    @Path("/getById/{Id}")
    @Produces("application/json")
    public AirportDTO getAirportById(@PathParam("Id")Long Id){
        return airportService.getAirportById(Id);
    }
}
