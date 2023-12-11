package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.FlightDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Models.AirportEntity;
import org.lova.Models.FlightEntity;
import org.lova.Repositories.AirlinesRepository;
import org.lova.Repositories.AirportRepository;
import org.lova.Repositories.FlightRepository;

import java.util.List;

@ApplicationScoped
public class FlightService {

    @Inject
    FlightRepository flightRepository;
    @Inject
    AirportRepository airportRepository;

    @Inject
    AirlinesRepository airlinesRepository;

    public void createFlight(FlightDTO flightDTO){
        FlightEntity flightEntity = new FlightEntity();
        AirlineEntity airlineEntity = airlinesRepository.getAirlineById(flightDTO.getAirlineId());
        AirportEntity airportArrivalEntity = airportRepository.getAirportById(flightDTO.getArrivalAirportId());
        AirportEntity airportDepartureEntity = airportRepository.getAirportById(flightDTO.getDepartureAirportId());
        flightEntity.setArrivalTime(flightDTO.getArrivalTime());
        flightEntity.setDepartureTime(flightDTO.getDepartureTime());
        flightEntity.setDepartureAirport(airportDepartureEntity);
        flightEntity.setArrivalAirport(airportArrivalEntity);
        flightEntity.setAirline(airlineEntity);

        flightRepository.createFlight(flightEntity);
    }

    public FlightDTO getFlightById(Long flightId){
        FlightEntity flightEntity = flightRepository.getFlightById(flightId);
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setFlightId(flightEntity.getFlightId());
        flightDTO.setAirlineId(flightEntity.getAirline().getAirlineId());
        flightDTO.setDepartureAirportId(flightEntity.getDepartureAirport().getAirportId());
        flightDTO.setArrivalAirportId(flightEntity.getArrivalAirport().getAirportId());
        flightDTO.setDepartureTime(flightEntity.getDepartureTime());
        flightDTO.setArrivalTime(flightEntity.getArrivalTime());

        return flightDTO;
    }

    public void deleteFlight(Long id) {flightRepository.deleteFlight(id);}

    public List<FlightDTO> getFlightsList(){
        List<FlightEntity> flightsList = flightRepository.getFlightsList();
        return flightsList.stream()
                .map(flightEntity -> {return new FlightDTO(flightEntity.getFlightId(), flightEntity.getDepartureAirport().getAirportId(), flightEntity.getArrivalAirport().getAirportId(), flightEntity.getAirline().getAirlineId(), flightEntity.getDepartureTime(), flightEntity.getArrivalTime());}).toList();
    }
}
