package com.ticket.myticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.myticket.model.Ticket;
import com.ticket.myticket.service.TicketService;

@RestController
public class TicketController {

	@Autowired
//	@Qualifier("TicketServiceImpl")
	TicketService TicketServiceSqlImpl;
	
//	@Autowired
//	@Qualifier("TicketServiceImpl")
//	TicketService ticketServiceMultiImpl;

	@PostMapping("/ticket")
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return TicketServiceSqlImpl.bookTicket(ticket);
	}

	@PostMapping("/multipletickets")
	public List<Ticket> bookmultipleTickets(@RequestBody List<Ticket> bookTicket) {
//		System.out.println(ticketServiceMultiImpl);
		System.out.println(TicketServiceSqlImpl);
		return TicketServiceSqlImpl.bookmultipleTickets(bookTicket);
	}

	@GetMapping("/ticket")
	public List<Ticket> getAllTickets(@RequestParam(name = "source", required = false) String source) {
		return TicketServiceSqlImpl.getAllTickets(source);
	}

	@PutMapping("/ticket/{ticketId}")
	public String updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		return TicketServiceSqlImpl.updateTicket(ticketId, ticket);
	}

	@PutMapping("/multipletickets")
	public String updateMultipleTickets(@RequestBody List<Ticket> updateTicket) {
		return TicketServiceSqlImpl.updateMultipleTickets(updateTicket);
	}

	@DeleteMapping("/ticket/{ticketId}")
	public String deleteTicket(@PathVariable("ticketId") int ticketId) {
		return TicketServiceSqlImpl.deleteTicket(ticketId);
	}

	@DeleteMapping("/multipletickets")
	public String deleteMultipleTickets(@RequestBody List<Integer> deleteTickets) {
		return TicketServiceSqlImpl.deleteMultipleTickets(deleteTickets);
	}
}
