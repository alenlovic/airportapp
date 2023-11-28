package org.lova.Models;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "airports")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airportSeq")
    @SequenceGenerator(name = "airportSeq", sequenceName = "airport_sequence", initialValue = 1, allocationSize = 1)
    @NotNull
    @Column(name = "airport_id")
    private Long airportId;

    @NotNull
    @Column(name = "airport_name")
    private String airportName;

    public AirportEntity(String airportName) { this.airportName = airportName;}
}
