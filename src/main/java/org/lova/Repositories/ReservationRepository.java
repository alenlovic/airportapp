package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.lova.DTO.ReservationUpdateDTO;
import org.lova.Models.ReservationEntity;


@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<ReservationEntity, Long> {

    public void createReservation(ReservationEntity reservationEntity) {getEntityManager().persist(reservationEntity);}

    public ReservationEntity getReservationById(Long id){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery <ReservationEntity> query = builder.createQuery(ReservationEntity.class);
        Root <ReservationEntity> root = query.from(ReservationEntity.class);

        return getEntityManager().createQuery(query).getSingleResult();
    }

    public void updateReservation(Long id, ReservationUpdateDTO reservationUpdateDTO){
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate <ReservationEntity> update = builder.createCriteriaUpdate(ReservationEntity.class);
        Root<ReservationEntity> root = update.from(ReservationEntity.class);

        update.where(builder.equal(root.get("reservationId"), id));


        if (reservationUpdateDTO.getOldReservationDateFrom() != null){
            update.set(root.get("reservationDateFrom"), reservationUpdateDTO.getNewReservationDateFrom());
        }
        if (reservationUpdateDTO.getOldReservationDateTo() != null){
            update.set(root.get("reservationDateTo"), reservationUpdateDTO.getNewReservationDateTo());
        }

        getEntityManager().createQuery(update).executeUpdate();
    }
}
