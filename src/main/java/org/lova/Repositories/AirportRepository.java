package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.*;
import org.hibernate.sql.Update;
import org.lova.DTO.AirportDTO;
import org.lova.Models.AirlineEntity;
import org.lova.Models.AirportEntity;

@ApplicationScoped
public class AirportRepository implements PanacheRepositoryBase<AirportEntity, Long> {

    public void createAirport(AirportEntity airportEntity) {getEntityManager().persist(airportEntity);}

    public AirportEntity getAirportById(Long airportId){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <AirportEntity> query = builder.createQuery(AirportEntity.class);
        Root <AirportEntity> root = query.from(AirportEntity.class);
        query.where(builder.equal(root.get("airportId"), airportId));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public AirportEntity getAirportByName(String airportName){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <AirportEntity> query = builder.createQuery(AirportEntity.class);
        Root <AirportEntity> root = query.from(AirportEntity.class);

        query.where(builder.equal(root.get("airportName"), airportName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void deleteAirport(Long airportId){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaDelete <AirportEntity> delete = builder.createCriteriaDelete(AirportEntity.class);
        Root <AirportEntity> root = delete.from(AirportEntity.class);
        delete.where(builder.equal(root.get("airportId"), airportId));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public void updateAirport(String oldAirportName, String newAirportName){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate <AirportEntity> update = builder.createCriteriaUpdate(AirportEntity.class);
        Root <AirportEntity> root = update.from(AirportEntity.class);

        update.where(builder.equal(root.get("airportName"), oldAirportName));
        update.set(root.get("airportName"), newAirportName);
        getEntityManager().createQuery(update).executeUpdate();
    }



}
