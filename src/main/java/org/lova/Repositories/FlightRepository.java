package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.*;
import org.lova.DTO.FlightDTO;
import org.lova.DTO.FlightUpdateDTO;
import org.lova.Models.FlightEntity;

import java.util.List;

@ApplicationScoped
public class FlightRepository implements PanacheRepositoryBase<FlightEntity, Long> {

    public void createFlight(FlightEntity flightEntity) {
        getEntityManager().persist(flightEntity);
    }

    public FlightEntity getFlightById(Long id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = builder.createQuery(FlightEntity.class);
        Root<FlightEntity> root = query.from(FlightEntity.class);
        query.where(builder.equal(root.get("id"), id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public List<FlightEntity> getFlightsList() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<FlightEntity> query = builder.createQuery(FlightEntity.class);
        query.from(FlightEntity.class);

        return getEntityManager().createQuery(query).getResultList();
    }

    public void deleteFlight(Long id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<FlightEntity> delete = builder.createCriteriaDelete(FlightEntity.class);
        Root<FlightEntity> root = delete.from(FlightEntity.class);
        delete.where(builder.equal(root.get("id"), id));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public void updateFlight(Long id, FlightUpdateDTO flightUpdateDTO){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate <FlightEntity> update = builder.createCriteriaUpdate(FlightEntity.class);
        Root<FlightEntity> root = update.from(FlightEntity.class);

        update.where(builder.equal(root.get("flightId"), id));

        if (flightUpdateDTO.getOldDepartureTime() != null) {
            update.set(root.get("departureTime"), flightUpdateDTO.getNewDepartureTime());
        }

        if (flightUpdateDTO.getOldArrivalTime() != null) {
            update.set(root.get("arrivalTime"), flightUpdateDTO.getNewArrivalTime());
        }

        getEntityManager().createQuery(update).executeUpdate();
    }

}
