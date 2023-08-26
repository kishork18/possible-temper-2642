package com.masai.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="product_id")
	    private int productId;
	    private String name;
	    private String category;
	    private String brand;
	    private double price;
	    @Column(name="stock_quantity")
	    private int stockQuantity;
	    @Enumerated
	    @Column(name="is_deleted")
	    private IsDeleted isDeleted;

	    @ManyToOne
	    @JoinColumn(name = "warehouse_id")
	    private Warehouse warehouse;

	    @OneToMany(mappedBy = "product")
	    private List<OrderItem> orderItems;

	    @OneToMany(mappedBy = "product")
	    private List<PurchaseHistory> purchaseHistory;
	    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    private Admin admin;

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(String name, String category, String brand, double price, int stockQuantity, IsDeleted isDeleted,
				Warehouse warehouse, List<OrderItem> orderItems, List<PurchaseHistory> purchaseHistory,Admin admin) {
			super();
			this.name = name;
			this.category = category;
			this.brand = brand;
			this.price = price;
			this.stockQuantity = stockQuantity;
			this.isDeleted = isDeleted;
			this.warehouse = warehouse;
			this.orderItems = orderItems;
			this.purchaseHistory = purchaseHistory;
			this.admin=admin;
		}

		public int getProductId() {
			return productId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}

		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}

		public IsDeleted getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(IsDeleted isDeleted) {
			this.isDeleted = isDeleted;
		}

		public Warehouse getWarehouse() {
			return warehouse;
		}

		public void setWarehouse(Warehouse warehouse) {
			this.warehouse = warehouse;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}

		public List<PurchaseHistory> getPurchaseHistory() {
			return purchaseHistory;
		}

		public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
			this.purchaseHistory = purchaseHistory;
		}

		public Admin getAdmin() {
			return admin;
		}

		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
	
	    
}
