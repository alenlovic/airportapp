package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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



}
