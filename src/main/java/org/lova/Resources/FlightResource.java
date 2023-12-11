package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.FlightDTO;
import org.lova.Models.FlightEntity;
import org.lova.Services.FlightService;

import java.util.List;

@ApplicationScoped
@Path("/flight")
@Transactional
public class FlightResource {
    @Inject
    FlightService flightService;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createFlight(FlightDTO flightDTO){flightService.createFlight(flightDTO);
    }

    @GET
    @Path("/getFlightList")
    @Consumes("application/json")
    public List<FlightDTO> getFlightList(FlightDTO flightDTO){ return flightService.getFlightsList();}
}
