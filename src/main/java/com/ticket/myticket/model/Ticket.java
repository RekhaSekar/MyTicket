package com.ticket.myticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MYTICKET")
public class Ticket {
	
	@Id
	@Column(name="ID")
	private int ticketId;
	@Column(name="SOURCE", nullable = false)
	private String source;
	@Column(name="DESTINATION",nullable = false)
	private String desination;
	@Column(name="JOURNEYDATE")
	private String journeyDate;
	@Column(name="COST")
	private double cost;

	public Ticket() {

	}

	public Ticket(int ticketId, String source, String desination, String journeyDate, double cost) {
		super();
		this.ticketId = ticketId;
		this.source = source;
		this.desination = desination;
		this.journeyDate = journeyDate;
		this.cost = cost;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDesination() {
		return desination;
	}

	public void setDesination(String desination) {
		this.desination = desination;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", source=" + source + ", desination=" + desination + ", journeyDate="
				+ journeyDate + ", cost=" + cost + "]";
	}

}
