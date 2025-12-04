package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "product_id")
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "category_id")   // FK
	    private Category category;

	    @Column(name = "product_name", nullable = false, length = 150)
	    private String name;

	    @Column(name = "description", length = 500)
	    private String description;

	    @Column(name = "price", nullable = false)
	    private Double price;

	    @Column(name = "stock")
	    private Integer stock;

	    @Column(name = "image_url")
	    private String imageUrl;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

	    @Column(name = "status")
	    private Boolean status = true;

	    public Product() {}

		public Product(Long id, Category category, String name, String description, Double price, Integer stock,
				String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean status) {
			super();
			this.id = id;
			this.category = category;
			this.name = name;
			this.description = description;
			this.price = price;
			this.stock = stock;
			this.imageUrl = imageUrl;
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

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Integer getStock() {
			return stock;
		}

		public void setStock(Integer stock) {
			this.stock = stock;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
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
			return "Product [id=" + id + ", category=" + category + ", name=" + name + ", description=" + description
					+ ", price=" + price + ", stock=" + stock + ", imageUrl=" + imageUrl + ", status=" + status + "]";
		}
	    
	    


}
