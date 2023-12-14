package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.FlightDTO;
import org.lova.DTO.FlightUpdateDTO;
import org.lova.Repositories.FlightRepository;
import org.lova.Services.FlightService;

import java.util.List;

@ApplicationScoped
@Path("/flight")
@Transactional
public class FlightResource {
    @Inject
    FlightService flightService;
    @Inject
    FlightRepository flightRepository;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createFlight(FlightDTO flightDTO) {
        flightService.createFlight(flightDTO);
    }

    @GET
    @Path("/getFlightById/{id}")
    @Produces("application/json")
    public FlightDTO getFlightById(@PathParam("id") Long id) {
        return flightService.getFlightById(id);
    }

    @GET
    @Path("/getFlightList")
    @Consumes("application/json")
    public List<FlightDTO> getFlightList(FlightDTO flightDTO) {
        return flightService.getFlightsList();
    }

    @DELETE
    @Path("/deleteFlight/{id}")
    @Consumes("application/json")
    public void deleteFlight(@PathParam("id") Long id) {
        flightService.deleteFlight(id);
    }

    @PUT
    @Path("/updateFlight/{id}")
    @Produces("application/json")
    public void updateFlight(@PathParam("id") Long id, FlightUpdateDTO flightUpdateDTO){
        flightRepository.updateFlight(id, flightUpdateDTO);
    }
}
