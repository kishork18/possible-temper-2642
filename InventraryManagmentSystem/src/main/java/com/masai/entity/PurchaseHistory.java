package com.masai.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PurchaseHistory")
public class PurchaseHistory {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "purchase_id")
	    private int purchaseId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;
	    @Column(name = "purchase_date")
	    private LocalDate purchaseDate;
	    private int quantity;
	    @Column(name = "total_price")
	    private double totalPrice;
	    @Enumerated
	    @Column(name="is_deleted")
	    private IsDeleted isDeleted;
		public PurchaseHistory() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PurchaseHistory(Customer customer, Product product, LocalDate purchaseDate, int quantity,
				double totalPrice, IsDeleted isDeleted) {
			super();
			this.customer = customer;
			this.product = product;
			this.purchaseDate = purchaseDate;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.isDeleted = isDeleted;
		}
		public int getPurchaseId() {
			return purchaseId;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public LocalDate getPurchaseDate() {
			return purchaseDate;
		}
		public void setPurchaseDate(LocalDate purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public IsDeleted getIsDeleted() {
			return isDeleted;
		}
		public void setIsDeleted(IsDeleted isDeleted) {
			this.isDeleted = isDeleted;
		}
	    
	    
}
