package com.ticket.myticket.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PriorityLevel {
	VERYLOW(1),LOW(2),MEDIUM(3),HIGH(4),VERYHIGH(5);

	private int value;

	private PriorityLevel(int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(value);
	}
	
	 public static Optional<PriorityLevel> valueOf(int value) {
		 return Arrays.stream(values())
	            .filter(priorityLevel -> priorityLevel.value == value)
	            .findFirst();
	    }
	
}
