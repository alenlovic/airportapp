package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.*;
import org.lova.DTO.PassengerUpdateDTO;
import org.lova.Models.PassengerEntity;


@ApplicationScoped
public class PassengerRepository implements PanacheRepositoryBase<PassengerEntity, Long> {

    public void createPassenger(PassengerEntity passengerEntity) {
        getEntityManager().persist(passengerEntity);
    }

    public PassengerEntity getPassengerById(Long id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root<PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("passengerId"), id));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void deletePassenger(Long passengerId) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<PassengerEntity> delete = builder.createCriteriaDelete(PassengerEntity.class);
        Root<PassengerEntity> root = delete.from(PassengerEntity.class);
        delete.where(builder.equal(root.get("passengerId"), passengerId));

        getEntityManager().createQuery(delete).executeUpdate();
    }

    public PassengerEntity getPassengerByFirstName(String firstName) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root<PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("PassengerFirstName"), firstName));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public PassengerEntity getPassengerByEmailAddress(String email) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<PassengerEntity> query = builder.createQuery(PassengerEntity.class);
        Root<PassengerEntity> root = query.from(PassengerEntity.class);
        query.where(builder.equal(root.get("PassengerEmailAddress"), email));

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void updatePassenger(Long id, PassengerUpdateDTO passengerUpdateDTO) {

        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate<PassengerEntity> criteriaUpdate = builder.createCriteriaUpdate(PassengerEntity.class);
        Root<PassengerEntity> root = criteriaUpdate.from(PassengerEntity.class);

        criteriaUpdate.where(builder.equal(root.get("passengerId"), id));

        if (passengerUpdateDTO.getOldFirstName() != null) {
            criteriaUpdate.set(root.get("firstName"),
                               passengerUpdateDTO.getNewFirstName());
        }

        if (passengerUpdateDTO.getOldFirstName() != null) {
            criteriaUpdate.set(root.get("lastName"),
                               passengerUpdateDTO.getNewLastName());
        }

        if (passengerUpdateDTO.getOldEmailAddress() != null) {
            criteriaUpdate.set(root.get("email"),
                               passengerUpdateDTO.getNewEmailAddress());
        }

        if (passengerUpdateDTO.getOldPhoneNumber() != null) {
            criteriaUpdate.set(root.get("phoneNumber"),
                               passengerUpdateDTO.getNewPhoneNumber());
        }

        getEntityManager().createQuery(criteriaUpdate).executeUpdate();
    }
}
