package com.ticket.myticket.dto;

import com.ticket.myticket.enums.PriorityLevel;

public class TicketDTO {
	private String title;
	private String description;
	private String category;
	private String department;
	private int priority;
	private int asignedToId;
	private String createdBy;
	private PriorityLevel pri;

	public TicketDTO() {

	}

	public TicketDTO(String title, String description, String category, String department, int priority,
			int asignedTo, String createdBy) {
		super();
		this.title = title;
		this.description = description;
		this.category = category;
		this.department = department;
		this.priority = priority;
		this.asignedToId = asignedTo;
		this.createdBy = createdBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getAsignedToId() {
		return asignedToId;
	}

	public void setAsignedToId(int asignedTo) {
		this.asignedToId = asignedTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public PriorityLevel getPri() {
		return pri;
	}

	public void setPri(PriorityLevel pri) {
		this.pri = pri;
	}

}
