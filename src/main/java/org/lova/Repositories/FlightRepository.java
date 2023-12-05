package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.lova.Models.FlightEntity;

@ApplicationScoped
public class FlightRepository implements PanacheRepositoryBase<FlightEntity, Long>{

    public void createFlight(FlightEntity flightEntity){getEntityManager().persist(flightEntity);}

    public FlightEntity getFlightById(Long id){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <FlightEntity> query = builder.createQuery(FlightEntity.class);
        Root <FlightEntity> root = query.from(FlightEntity.class);

        return getEntityManager().createQuery(query).getSingleResult();
    }
}
