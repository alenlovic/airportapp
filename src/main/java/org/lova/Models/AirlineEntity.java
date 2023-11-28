package org.lova.Models;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "airlines")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AirlineEntity {

    @Id
    @SequenceGenerator(name = "airlineSeq", sequenceName = "airline_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airlineSeq")
    @Column(name = "airline_id")
    private Long airlineId;

    @NotNull
    @Column(name = "airline_name")
    private String airlineName;

    public AirlineEntity(String airlineName) { this.airlineName = airlineName; }

}
