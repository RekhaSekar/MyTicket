package com.ticket.myticket.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.myticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByCategoryAndAsignedToEmail(String category, String email);
}
