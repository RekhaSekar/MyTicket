package com.ticket.myticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "category")
	private String category;

	@Column(name = "department")
	private String department;

	@Column(name = "priority")
	private int priority;

	@OneToOne
	private Employee asignedTo;

	@Column(name = "createdBy")
	private String createdBy;

	public Ticket() {

	}

	public Ticket(int id, String title, String description, String category, String department, int priority,
			Employee asignedTo, String createdBy) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.department = department;
		this.priority = priority;
		this.asignedTo = asignedTo;
		this.createdBy = createdBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Employee getAsignedTo() {
		return asignedTo;
	}

	public void setAsignedTo(Employee asignedTo) {
		this.asignedTo = asignedTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
