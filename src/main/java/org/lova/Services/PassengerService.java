package org.lova.Services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.lova.DTO.PassengerDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Models.PassengerEntity;
import org.lova.Repositories.PassengerRepository;

import java.util.List;

@ApplicationScoped
public class PassengerService {

    @Inject
    PassengerRepository repo;

    public void createPassenger(PassengerDTO passengerDTO) {
        PassengerEntity entity = new PassengerEntity();
        entity.setFirstName(passengerDTO.getFirstName());
        entity.setLastName(passengerDTO.getLastName());
        entity.setEmail(passengerDTO.getEmail());
        entity.setPhoneNumber(passengerDTO.getPhoneNumber());
        repo.createPassenger(entity);
    }

    public PassengerDTO getPassengerById(Long Id) {
        PassengerEntity passenger = repo.getPassengerById(Id);
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setPassengerId(passenger.getPassengerId());
        passengerDTO.setFirstName(passenger.getFirstName());
        passengerDTO.setLastName(passenger.getLastName());
        passengerDTO.setEmail(passenger.getEmail());
        passengerDTO.setPhoneNumber(passenger.getPhoneNumber());

        return passengerDTO;
    }

    public void deletePassengerId(Long passengerId) {
        repo.deletePassenger(passengerId);
    }

    public PassengerDTO getPassengerByFirstName(String passengerFirstName) {
        PassengerEntity passenger = repo.getPassengerByFirstName(passengerFirstName);
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName(passenger.getFirstName());
        passengerDTO.setLastName(passenger.getLastName());
        passengerDTO.setEmail(passenger.getEmail());
        passengerDTO.setPhoneNumber(passenger.getPhoneNumber());

        return passengerDTO;
    }

    public PassengerDTO getPassengerByEmailAddress(String email) {
        PassengerEntity passenger = repo.getPassengerByEmailAddress(email);
        PassengerDTO passengerDTO = new PassengerDTO();
        passengerDTO.setFirstName(passenger.getFirstName());
        passengerDTO.setLastName(passenger.getLastName());
        passengerDTO.setEmail(passenger.getEmail());
        passengerDTO.setPhoneNumber(passenger.getPhoneNumber());

        return passengerDTO;
    }

    public List<PassengerDTO> getPassengerList(){
        List<PassengerEntity> passenger = repo.getPassengerList();
        return passenger.stream().map(passengerEntity -> {
            return new PassengerDTO(
                    passengerEntity.getPassengerId(),
                    passengerEntity.getFirstName(),
                    passengerEntity.getLastName(),
                    passengerEntity.getEmail(),
                    passengerEntity.getPhoneNumber());
        }).toList();
    }
}
