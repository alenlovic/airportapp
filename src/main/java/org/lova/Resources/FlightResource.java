package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.lova.DTO.FlightDTO;
import org.lova.Models.FlightEntity;
import org.lova.Services.FlightService;

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
}
