package org.lova.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private Long passengerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
