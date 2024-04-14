package com.ticket.myticket.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ticket.myticket.Exception.TicketException;
import com.ticket.myticket.dto.TicketDTO;
import com.ticket.myticket.enums.PriorityLevel;
import com.ticket.myticket.model.Employee;
import com.ticket.myticket.model.Ticket;
import com.ticket.myticket.repo.EmployeeRepository;
import com.ticket.myticket.repo.TicketRepository;
import com.ticket.myticket.service.TicketService;

@Service
public class TicketServiceSqlImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Ticket assignTicket(TicketDTO ticketDTO) {
		try {
			return ticketRepository.save(this.convertTicketDTOtoEntity(ticketDTO));
		}catch(Exception exception) {
//			System.out.println(exception.getMessage());
			throw new TicketException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
		}
		
	}

	@Override
	public List<TicketDTO> getAllTickets(String source, String email) {
//		return ticketRepository.findAll().stream().map(this::convertEntitytoTicketDTO).collect(Collectors.toList());
		return ticketRepository.findByCategoryAndAsignedToEmail(source, email).stream().map(this::convertEntitytoTicketDTO).collect(Collectors.toList());
	}

	@Override
	public String updateTicket(int ticketId, Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTicket(int ticketId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Ticket convertTicketDTOtoEntity(TicketDTO ticketDTO) {
		Optional<Employee> employee = employeeRepository.findById(ticketDTO.getAsignedToId());
		if(employee.isEmpty()) {
			throw new TicketException(HttpStatus.NO_CONTENT,"Employee not found",null);
		}
		Ticket ticket = new Ticket();
		ticket.setAsignedTo(employee.get());
		ticket.setTitle(ticketDTO.getTitle());
		ticket.setDepartment(ticketDTO.getDepartment());
		ticket.setDescription(ticketDTO.getDescription());
		ticket.setCategory(ticketDTO.getCategory());
		ticket.setCreatedBy(ticketDTO.getCreatedBy());
//		ticket.setPriority(ticketDTO.getPriority());
		ticket.setPriority(ticketDTO.getPri().ordinal());
		return ticket;
	}
	
	public TicketDTO convertEntitytoTicketDTO(Ticket ticket) {
		TicketDTO TicketDTO = new TicketDTO();
		TicketDTO.setAsignedToId(ticket.getAsignedTo().getId());
		TicketDTO.setTitle(ticket.getTitle());
		TicketDTO.setDepartment(ticket.getDepartment());
		TicketDTO.setDescription(ticket.getDescription());
		TicketDTO.setCategory(ticket.getCategory());
		TicketDTO.setCreatedBy(ticket.getCreatedBy());
//		TicketDTO.setPriority(ticket.getPriority());
		TicketDTO.setPri(PriorityLevel.valueOf(ticket.getPriority()).get());
		return TicketDTO;
	}
}
