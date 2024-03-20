package com.ticket.myticket.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.ticket.myticket.Exception.TicketException;
import com.ticket.myticket.model.Ticket;
import com.ticket.myticket.service.TicketService;

//@Service("ticketServiceMultipleImpl1")
//@Qualifier("TicketServiceImpl")
//@Primary
@Service
//@Scope("prototype")
public class TicketServiceImpl implements TicketService {
	List<Ticket> tickets = new ArrayList<>();
	private int availableTickets = 50;

	public Ticket bookTicket(Ticket ticket) {
		if (availableTickets > 0) {
			tickets.add(ticket);
		}
		System.out.println("Available Tickets in impl: " + (--availableTickets));
		return ticket;
	}

	public List<Ticket> getAllTickets(String source) {
		if (source != null) {
			return tickets.stream().filter(ticket -> ticket.getSource().equals(source)).collect(Collectors.toList());
		}
		return tickets;
	}

	public String updateTicket(int ticketId, Ticket ticket) {
		for (Ticket ticket1 : tickets) {
			if (ticket1.getTicketId() == ticketId) {
				tickets.remove(ticket1);
				tickets.add(ticket);
				return "Ticket is successfully updated";
			}
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}

	public String deleteTicket(int ticketId) {
		for (Ticket ticket1 : tickets) {
			if (ticket1.getTicketId() == ticketId) {
				tickets.remove(ticket1);
				return "Ticket is successfully deleted";
			}
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}

	public List<Ticket> bookmultipleTickets(List<Ticket> bookTicket) {
		if (availableTickets >= bookTicket.size()) {
			tickets.addAll(bookTicket);
		}
		availableTickets -= bookTicket.size();
		System.out.println("Available Tickets in impl: " + availableTickets);
		return bookTicket;
	}

	public String updateMultipleTickets(List<Ticket> updateTicket) {
//		for (Ticket ticket1 : updateTicket) {
//			tickets.removeIf(ticket -> ticket.getTicketId() == ticket1.getTicketId());
//		}
//		tickets.addAll(updateTicket);
		boolean isPresent = false;
		String value = "";
		for (int i = 0; i < tickets.size(); i++) {
			for (int j = 0; j < updateTicket.size(); j++) {
				if (tickets.get(i).getTicketId() == updateTicket.get(j).getTicketId()) {
					tickets.remove(i);
					tickets.add(i, updateTicket.get(j));
					isPresent = true;
					value = value + updateTicket.get(j).getTicketId() + " ";
				}
			}
		}
		if (isPresent) {
			return "Ticket successfully updated with ticket ID: " + value;
		} else {
			throw new TicketException(404, "Ticket Not found", null);
		}

	}

	public String deleteMultipleTickets(List<Integer> deleteTickets) {
		for (Integer ticketId : deleteTickets) {
			tickets.removeIf(ticket -> ticket.getTicketId() == ticketId);
		}
		return "Ticket is successfully deleted";
	}
}
