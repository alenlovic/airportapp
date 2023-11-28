package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lova.DTO.AirlinesDTO;
import org.lova.Models.AirlineEntity;

import java.util.List;

@ApplicationScoped
public class AirlinesRepository implements PanacheRepositoryBase<AirlineEntity, Long> {


    public void createAirline(AirlineEntity airlineEntity){
        getEntityManager().persist(airlineEntity);
    }
    public AirlineEntity getAirlineById(Long airlineId){

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <AirlineEntity> query = builder.createQuery(AirlineEntity.class);
        Root <AirlineEntity> root = query.from(AirlineEntity.class);
        query.where(builder.equal(root.get("airlineId"), airlineId));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void deleteAirline(Long airlineId) {

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<AirlineEntity> delete = builder.createCriteriaDelete(AirlineEntity.class);
        Root <AirlineEntity> root = delete.from(AirlineEntity.class);
        delete.where(builder.equal(root.get("airlineId"), airlineId));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public List<AirlineEntity> getAirlineList(){

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <AirlineEntity> query = builder.createQuery(AirlineEntity.class);
        query.from(AirlineEntity.class);

        return getEntityManager().createQuery(query).getResultList();
    }


    public AirlineEntity getAirlineByName(String airlineName) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <AirlineEntity> query = builder.createQuery(AirlineEntity.class);
        Root <AirlineEntity> root = query.from(AirlineEntity.class);
        query.where(builder.equal(root.get("airlineName"), airlineName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void updateAirline(String oldName, String newName){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate<AirlineEntity> updateData = builder.createCriteriaUpdate(AirlineEntity.class);
        Root <AirlineEntity> root = updateData.from(AirlineEntity.class);


        updateData.where(builder.equal(root.get("airlineName"), oldName));
        updateData.set(root.get("airlineName"), newName);
        getEntityManager().createQuery(updateData).executeUpdate();
    }


}
