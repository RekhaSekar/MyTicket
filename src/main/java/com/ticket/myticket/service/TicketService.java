package com.ticket.myticket.service;

import java.util.List;

import com.ticket.myticket.model.Ticket;

public interface TicketService {

	public Ticket bookTicket(Ticket ticket);

	public List<Ticket> getAllTickets(String source);

	public String updateTicket(int ticketId, Ticket ticket);

	public String deleteTicket(int ticketId);

	public List<Ticket> bookmultipleTickets(List<Ticket> bookTicket);

	public String updateMultipleTickets(List<Ticket> updateTicket);

	public String deleteMultipleTickets(List<Integer> deleteTickets);

}
