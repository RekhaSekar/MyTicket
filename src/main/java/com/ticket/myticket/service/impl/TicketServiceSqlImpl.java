package com.ticket.myticket.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ticket.myticket.Exception.TicketException;
import com.ticket.myticket.model.Ticket;
import com.ticket.myticket.repo.TicketRepository;
import com.ticket.myticket.service.TicketService;

@Service
//@Qualifier("TicketServiceMultipleImpl")
@Primary
public class TicketServiceSqlImpl implements TicketService {

	List<Ticket> tickets = new ArrayList<>();
	private int availableTickets = 50;
	@Autowired
	TicketRepository ticketRepository;

	public Ticket bookTicket(Ticket ticket) {
		if (ticketRepository.existsById(ticket.getTicketId())) {
			throw new TicketException(404, "Ticket with ticketId: "+ticket.getTicketId()+" already exists!!", null);
		}
		return ticketRepository.save(ticket);
	}

	public List<Ticket> getAllTickets(String source) {
		return ticketRepository.findAll();
	}

	public String updateTicket(int ticketId, Ticket ticket) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.save(ticket);
			return "Ticket updated successfully";
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}

	public String deleteTicket(int ticketId) {
		if (ticketRepository.existsById(ticketId)) {
			ticketRepository.deleteById(ticketId);
			return "Ticket deleted successfully";
		}
		throw new TicketException(404, "Ticket Not found with id " + ticketId, null);
	}

	public List<Ticket> bookmultipleTickets(List<Ticket> bookTicket) {
		return ticketRepository.saveAll(bookTicket);	
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
