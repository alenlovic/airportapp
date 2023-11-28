package org.lova.DTO;

import lombok.Data;

@Data
public class PassengerUpdateDTO {
    private String oldFirstName;
    private String newFirstName;
    private String oldLastName;
    private String newLastName;
    private String oldEmailAddress;
    private String newEmailAddress;
    private String oldPhoneNumber;
    private String newPhoneNumber;
}
