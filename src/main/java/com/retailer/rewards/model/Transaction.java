package com.retailer.rewards.model;

import java.time.LocalDate;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long transactionId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Customer customer;
	@Column(name = "amount")
	private Long transactionAmount;
	private String description;
	@Column(name = "save_date")
	private LocalDate transactionDate;
	@Transient    //marking a field as not persistable
	protected int transactionRewardPoints;
	
	public Transaction() {
		super();
	}

	public Transaction(Long transactionId, Customer customer, Long transactionAmount, String description, LocalDate transactionDate) {
		this.transactionId = transactionId;
		this.customer = customer;
		this.transactionAmount = transactionAmount;
		this.description = description;
		this.transactionDate = transactionDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransactionRewardPoints() {
		this.transactionRewardPoints = 0;
		if (this.transactionAmount > 50 && this.transactionAmount <= 100) {
			this.transactionRewardPoints += (this.transactionAmount.intValue() - 50) * 1;
		}
		if (this.transactionAmount > 100) {
			this.transactionRewardPoints += 50;  //1 point for every dollar spent over $50
			this.transactionRewardPoints += (this.transactionAmount.intValue() - 100) * 2;  //2 points for every dollar spent over $100
		}
		return this.transactionRewardPoints;
	}
	
	@Override
	public String toString() {
		return String.format("Transaction [transactionId=%s, customer=%s, transactionAmount=%s, description=%s, transactionDate=%s]", transactionId, customer,
				transactionAmount, description, transactionDate);
	}
	
}
