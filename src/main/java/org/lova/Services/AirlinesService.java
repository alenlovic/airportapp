package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.AirlinesDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Repositories.AirlinesRepository;

import java.util.List;

@ApplicationScoped
public class AirlinesService {

    @Inject
    AirlinesRepository repo;


    public void createAirline(AirlinesDTO airlinesDTO) {
        AirlineEntity entity = new AirlineEntity();
        entity.setAirlineName(airlinesDTO.getAirlineName());
        repo.createAirline(entity);
    }

    public AirlinesDTO getAirlineById(Long airlineId) {
        AirlineEntity airline = repo.getAirlineById(airlineId);
        AirlinesDTO airlinesDTO = new AirlinesDTO();
        airlinesDTO.setAirlineName(airline.getAirlineName());

        return airlinesDTO;
    }

    public void deleteAirline(Long airlineId) { repo.deleteAirline(airlineId); }

    public AirlinesDTO getAirlineByName(String airlineName) {
        AirlineEntity airline = repo.getAirlineByName(airlineName);
        AirlinesDTO airlinesDTO = new AirlinesDTO();
        airlinesDTO.setAirlineId(airline.getAirlineId());
        airlinesDTO.setAirlineName(airline.getAirlineName());

        return airlinesDTO;
    }

    // public List<AirlinesDTO> getAirlinesList(Long airlineId, String airlineName){}
}
