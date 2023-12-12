package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.AirlinesDTO;
import org.lova.DTO.AirportDTO;
import org.lova.Models.AirportEntity;
import org.lova.Repositories.AirportRepository;

import java.util.List;

@ApplicationScoped
public class AirportService {

    @Inject
    AirportRepository repo;

    public void createAirport(AirportDTO airportDTO) {
        AirportEntity entity = new AirportEntity();
        entity.setAirportName(airportDTO.getAirportName());
        repo.createAirport(entity);
    }

    public AirportDTO getAirportById(Long airportId) {
        AirportEntity airport = repo.getAirportById(airportId);
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportId(airport.getAirportId());
        airportDTO.setAirportName(airport.getAirportName());

        return airportDTO;
    }

    public AirportDTO getAirportByName(String airportName) {
        AirportEntity airport = repo.getAirportByName(airportName);
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportId(airport.getAirportId());
        airportDTO.setAirportName(airport.getAirportName());

        return airportDTO;
    }

    public List<AirportDTO> getAirportList() {
        List<AirportEntity> airportList = repo.getAirportList();
        return airportList.stream()
                .map(airportEntity -> {
                    return new AirportDTO(airportEntity.getAirportId(),
                                          airportEntity.getAirportName());
                }).toList();
    }
}
