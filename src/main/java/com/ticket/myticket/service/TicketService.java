package com.ticket.myticket.service;

import java.util.List;

import com.ticket.myticket.dto.TicketDTO;
import com.ticket.myticket.model.Ticket;

public interface TicketService {

	public Ticket assignTicket(TicketDTO ticketDTO);

	public List<TicketDTO> getAllTickets(String source, String email);

	public String updateTicket(int ticketId, Ticket ticket);

	public String deleteTicket(int ticketId);

}
