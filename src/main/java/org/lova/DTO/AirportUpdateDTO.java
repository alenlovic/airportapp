package org.lova.DTO;

import lombok.Data;

@Data
public class AirportUpdateDTO {
    private String oldAirportName;
    private String newAirportName;
}
