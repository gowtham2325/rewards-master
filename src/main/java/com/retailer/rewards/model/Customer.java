package com.retailer.rewards.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer customerId;
    @Column(name = "name")
    private String customerName;
    @Transient
    private Map<Month, Integer> monthlyAccumulatedRewardPoints;
    @Transient
    private int totalAccumulatedRewardPoints;
    @Transient
    private Long totalPurchases;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions;

    public Customer() {
        super();
    }

    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getTotalAccumulatedRewardPoints() {
        if (transactions == null || transactions.isEmpty()) return 0;

        return transactions.stream().map(x -> x.getTransactionRewardPoints()).reduce(0, (a, b) -> a + b);
    }

    public Long getTotalPurchases() {
        if (transactions == null || transactions.isEmpty()) return 0L;
        return transactions.stream().map(x -> x.getTransactionAmount()).reduce(0L, (a, b) -> a + b);
    }

    public Map<Month, Integer> getMonthlyAccumulatedRewardPoints() {
        monthlyAccumulatedRewardPoints = new HashMap<>();
        if (transactions == null || transactions.isEmpty())
            return monthlyAccumulatedRewardPoints;

        Consumer<Transaction> aggregatePoints = x -> {
            if ((LocalDate.now().getMonthValue() - x.getTransactionDate().getMonthValue()) < 3) {
                if (monthlyAccumulatedRewardPoints.get(x.getTransactionDate().getMonth()) == null)
                    monthlyAccumulatedRewardPoints.put(x.getTransactionDate().getMonth(), 0);
                monthlyAccumulatedRewardPoints.put(x.getTransactionDate().getMonth(), monthlyAccumulatedRewardPoints.get(x.getTransactionDate().getMonth()) + x.getTransactionRewardPoints());
            }
        };
        transactions.stream().forEach(aggregatePoints);
        return monthlyAccumulatedRewardPoints;
    }
}
