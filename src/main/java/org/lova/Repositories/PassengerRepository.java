package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.*;
import org.lova.Models.AirlineEntity;
import org.lova.Models.PassengerEntity;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PassengerRepository implements PanacheRepositoryBase<PassengerEntity, Long> {

    public void createPassenger(PassengerEntity passengerEntity) { getEntityManager().persist(passengerEntity);}

    public PassengerEntity getPassengerById(Long id){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root<PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("passengerId"), id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void deletePassenger(Long passengerId){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<PassengerEntity> delete = builder.createCriteriaDelete(PassengerEntity.class);
        Root <PassengerEntity> root = delete.from(PassengerEntity.class);
        delete.where(builder.equal(root.get("passengerId"), passengerId));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public PassengerEntity getPassengerByFirstName(String firstName){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root <PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("PassengerFirstName"), firstName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public PassengerEntity getPassengerByEmailAddress(String email){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root <PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("PassengerEmailAddress"), email));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void updatePassenger(String oldFirstName, String newFirstName, String oldLastName, String newLastName,
                                String oldEmailAddress, String newEmailAddress, String oldPhoneNumber, String newPhoneNumber){

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate <PassengerEntity> criteriaUpdate = builder.createCriteriaUpdate(PassengerEntity.class);
        Root <PassengerEntity> root = criteriaUpdate.from(PassengerEntity.class);


        List<Predicate> predicates = new ArrayList<>();

        if (oldFirstName != null) {
            predicates.add(builder.equal(root.get("firstName"), oldFirstName));
            criteriaUpdate.set(root.get("firstName"), newFirstName);
        }

        if (oldLastName != null) {
            predicates.add(builder.equal(root.get("lastName"), oldLastName));
            criteriaUpdate.set(root.get("lastName"), newLastName);
        }

        if (oldEmailAddress != null) {
            predicates.add(builder.equal(root.get("email"), oldEmailAddress));
            criteriaUpdate.set(root.get("email"), newEmailAddress);
        }

        if (oldPhoneNumber != null) {
            predicates.add(builder.equal(root.get("phoneNumber"), oldPhoneNumber));
            criteriaUpdate.set(root.get("phoneNumber"), newPhoneNumber);
        }

        Predicate finalCondition = builder.and(predicates.toArray(new Predicate[0]));

        criteriaUpdate.where(finalCondition);

        getEntityManager().createQuery(criteriaUpdate).executeUpdate();
    }
}
