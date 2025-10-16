package com.st.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // Marks this class as a JPA entity (a table in the DB)
@Table
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID
    private Long id;
    private String category;
    private String description;
    private LocalDate date;
    private BigDecimal amount;
    // To handle the "Group" expense logic
    private Integer splitWith; // Number of members to split with (can be null for personal)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getSplitWith() {
		return splitWith;
	}
	public void setSplitWith(Integer splitWith) {
		this.splitWith = splitWith;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ", category=" + category + ", description=" + description + ", date=" + date
				+ ", amount=" + amount + ", splitWith=" + splitWith + "]";
	}
	public Expense(Long id, String category, String description, LocalDate date, BigDecimal amount, Integer splitWith) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.splitWith = splitWith;
	}
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
