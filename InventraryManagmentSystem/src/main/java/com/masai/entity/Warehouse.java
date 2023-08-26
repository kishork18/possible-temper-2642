package com.masai.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Warehouses")
public class Warehouse {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "warehouse_id")
	    private int warehouseId;
	    private String name;
	    private String location;
	    private int capacity;
	    @Enumerated
	    @Column(name="is_deleted")
	    private IsDeleted isDeleted;

	    @OneToMany(mappedBy = "warehouse")
	    private List<Product> products;

		public Warehouse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Warehouse(String name, String location, int capacity, IsDeleted isDeleted, List<Product> products) {
			super();
			this.name = name;
			this.location = location;
			this.capacity = capacity;
			this.isDeleted = isDeleted;
			this.products = products;
		}

		public int getWarehouseId() {
			return warehouseId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public IsDeleted getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(IsDeleted isDeleted) {
			this.isDeleted = isDeleted;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}
	    
}
