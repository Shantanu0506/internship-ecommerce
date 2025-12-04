package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // customer_id FK → users
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "order_status", length = 50, nullable = false)
    private String orderStatus;      // Pending / Shipped / Delivered / Cancelled

    @Column(name = "shipping_address", length = 300)
    private String shippingAddress;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "status")
    private Boolean status = true;   // TRUE = active, FALSE = cancelled (soft delete)

    public Order() {}

	public Order(Long id, User customer, Double totalAmount, String orderStatus, String shippingAddress,
			LocalDateTime createdAt, LocalDateTime updatedAt, Boolean status) {
		super();
		this.id = id;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.shippingAddress = shippingAddress;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", totalAmount=" + totalAmount + ", orderStatus="
				+ orderStatus + ", shippingAddress=" + shippingAddress + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", status=" + status + "]";
	}
    
    
}
