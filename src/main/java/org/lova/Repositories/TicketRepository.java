package org.lova.Repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.lova.Models.TicketEntity;

@ApplicationScoped
public class TicketRepository implements PanacheRepositoryBase<TicketEntity, Long> {

    public void createTicket(TicketEntity ticketEntity) {getEntityManager().persist(ticketEntity);

    }
}
