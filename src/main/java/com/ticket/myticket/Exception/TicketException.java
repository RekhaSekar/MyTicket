package com.ticket.myticket.Exception;

import org.springframework.http.HttpStatus;

public class TicketException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;

	public TicketException(HttpStatus httpStatus, String message, Throwable cause) {
		super(message);
		this.httpStatus=httpStatus;

	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
