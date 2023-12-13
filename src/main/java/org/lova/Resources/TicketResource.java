package org.lova.Resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.lova.DTO.TicketCreateDTO;
import org.lova.DTO.TicketDTO;
import org.lova.Services.TicketService;

import java.util.List;

@Transactional
@ApplicationScoped
@Path("/ticket")
public class TicketResource {

    @Inject
    TicketService ticketService;

    @POST
    @Path("/create")
    @Consumes("application/json")
    public void createTicket(TicketCreateDTO ticketCreateDTO) {
        ticketService.createTicket(ticketCreateDTO);
    }

    @GET
    @Path("/getById/{id}")
    @Produces("application/json")
    public TicketDTO getTicketById(@PathParam("id") Long id) {
        return ticketService.getTicketById(id);
    }

    @GET
    @Path("/getTicketList")
    @Consumes("application/json")
    public List<TicketCreateDTO> getTicketList(TicketCreateDTO ticketCreateDTO) {
        return ticketService.getTicketList();
    }
}
