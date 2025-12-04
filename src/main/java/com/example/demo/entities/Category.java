package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "category_id")
	    private Integer id;

	    @Column(name = "category_name", nullable = false, length = 100)
	    private String name;

	    @Column(name = "description", length = 300)
	    private String description;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

	    @Column(name = "status")
	    private Boolean status = true;   // default active

		public Category(Integer id, String name, String description, LocalDateTime createdAt, LocalDateTime updatedAt,
				Boolean status) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.status = status;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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
			return "Category [id=" + id + ", name=" + name + ", description=" + description + ", createdAt=" + createdAt
					+ ", updatedAt=" + updatedAt + ", status=" + status + "]";
		}
	    
	    
}
