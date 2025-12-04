package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shippingId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String courierService;

    private String trackingNumber;

    private String shippingStatus;

    private Double shippingCost;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	public Shipping(Integer shippingId, Order order, String courierService, String trackingNumber,
			String shippingStatus, Double shippingCost, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.shippingId = shippingId;
		this.order = order;
		this.courierService = courierService;
		this.trackingNumber = trackingNumber;
		this.shippingStatus = shippingStatus;
		this.shippingCost = shippingCost;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getCourierService() {
		return courierService;
	}

	public void setCourierService(String courierService) {
		this.courierService = courierService;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
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

	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", order=" + order + ", courierService=" + courierService
				+ ", trackingNumber=" + trackingNumber + ", shippingStatus=" + shippingStatus + ", shippingCost="
				+ shippingCost + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
}

