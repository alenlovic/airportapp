package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

}
