package com.ticket.myticket.Exception;

public class TicketException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int statusCode;

	public TicketException(int statusCode, String message, Throwable cause) {
		super(message);
		this.statusCode=statusCode;

	}

	public int getStatusCode() {
		return statusCode;
	}

}
