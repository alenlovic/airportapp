package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.AirportDTO;
import org.lova.DTO.AirportUpdateDTO;
import org.lova.Repositories.AirportRepository;
import org.lova.Services.AirportService;

import java.util.List;

@Path("/airport")
@Transactional
@ApplicationScoped
public class AirportResource {
    @Inject
    AirportService airportService;
    @Inject
    AirportRepository airportRepository;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createAirport(AirportDTO airportDTO) {
        airportService.createAirport(airportDTO);
    }

    @GET
    @Path("/getById/{id}")
    @Produces("application/json")
    public AirportDTO getAirportById(@PathParam("id") Long id) {
        return airportService.getAirportById(id);
    }

    @GET
    @Path("/getAirportByName/{airportName}")
    @Produces("application/json")
    public AirportDTO getAirportByName(@PathParam("airportName") String airportName) {
        return airportService.getAirportByName(airportName);
    }

    @DELETE
    @Path("/delete/{Id}")
    @Produces("application/json")
    public void deleteAirport(@PathParam("Id") Long airportId) {
        airportRepository.deleteAirport(airportId);
    }

    @PUT
    @Path("/update/{Id}")
    @Consumes("application/json")
    public void updateAirport(@PathParam("Id") Long Id, AirportUpdateDTO airportUpdateDTO) {
        airportRepository.updateAirport(airportUpdateDTO.getOldAirportName(),
                                        airportUpdateDTO.getNewAirportName());
    }

    @GET
    @Path("/getList")
    @Consumes("application/json")
    public List<AirportDTO> getAirportList() {
        return airportService.getAirportList();
    }
}
