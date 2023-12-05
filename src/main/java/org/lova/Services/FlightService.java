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
        flightEntity.setDepartureAirportEntity(airportDepartureEntity);
        flightEntity.setArrivalAirportEntity(airportArrivalEntity);
        flightEntity.setAirlineEntity(airlineEntity);

        flightRepository.createFlight(flightEntity);
    }
}
