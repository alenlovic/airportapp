package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.AirlinesDTO;
import org.lova.DTO.AirportDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Models.AirportEntity;
import org.lova.Repositories.AirportRepository;

@ApplicationScoped
public class AirportService {

    @Inject
    AirportRepository repo;

    public void createAirport(AirportDTO airportDTO){
        AirportEntity entity = new AirportEntity();
        entity.setAirportName(airportDTO.getAirportName());
        repo.createAirport(entity);
    }

    public AirportDTO getAirportById(Long airportId){
        AirportEntity airport = repo.getAirportById(airportId);
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportId(airport.getAirportId());
        airportDTO.setAirportName(airport.getAirportName());

        return airportDTO;
    }
}
