package com.ticket.myticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.myticket.dto.TicketDTO;
import com.ticket.myticket.model.Ticket;
import com.ticket.myticket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	TicketService TicketServiceSqlImpl;
	
	@PostMapping("/")
	public ResponseEntity<Ticket> assignTicket(@RequestBody TicketDTO ticketDTO) {
		return new ResponseEntity<>(TicketServiceSqlImpl.assignTicket(ticketDTO),HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<List<TicketDTO>> getAllTickets(@RequestParam(name = "source", required = false) String source,@RequestParam(name = "email", required = false) String email ) {
		return new ResponseEntity<>(TicketServiceSqlImpl.getAllTickets(source, email), HttpStatus.OK);
	}

	@PutMapping("/{ticketId}")
	public ResponseEntity<String> updateTicket(@PathVariable("ticketId") int ticketId, @RequestBody Ticket ticket) {
		return new ResponseEntity<>(TicketServiceSqlImpl.updateTicket(ticketId, ticket), HttpStatus.OK);
	}

	@DeleteMapping("/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") int ticketId) {
		return new ResponseEntity<>(TicketServiceSqlImpl.deleteTicket(ticketId), HttpStatus.OK);
	}

}
