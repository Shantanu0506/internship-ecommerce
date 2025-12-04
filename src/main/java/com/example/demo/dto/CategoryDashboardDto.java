package com.example.demo.dto;


public class CategoryDashboardDto {

    private Integer id;
    private String name;
    private String description;
    private Boolean status;
    private Long productCount;

    public CategoryDashboardDto(Integer id, String name,
                                String description, Boolean status,
                                Long productCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.productCount = productCount;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Boolean getStatus() { return status; }

    public void setStatus(Boolean status) { this.status = status; }

    public Long getProductCount() { return productCount; }

    public void setProductCount(Long productCount) { this.productCount = productCount; }
}
