package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.lova.Models.TicketEntity;

@ApplicationScoped
public class TicketRepository implements PanacheRepositoryBase<TicketEntity, Long> {

    public void createTicket(TicketEntity ticketEntity) {
        getEntityManager().persist(ticketEntity);
    }

    public TicketEntity getTicketById(Long id) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TicketEntity> query = builder.createQuery(TicketEntity.class);
        Root<TicketEntity> root = query.from(TicketEntity.class);

        return getEntityManager().createQuery(query).getSingleResult();
    }
}
