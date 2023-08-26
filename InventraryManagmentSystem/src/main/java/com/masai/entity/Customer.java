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
@Table(name = "Customers") 
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	   private int customerId;
	    private String username;
	    private String password;
	    private String name;
	    private String email;
	    private String phone;
	    private String address;
	    @Enumerated
	    @Column(name="is_deleted")
	    private IsDeleted isDeleted;
	    @OneToMany(mappedBy = "customer")
	    private List<SalesOrder> salesOrders;

	    @OneToMany(mappedBy = "customer")
	    private List<PurchaseHistory> purchaseHistory;

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Customer(String username, String password, String name, String email, String phone, String address,
				IsDeleted isDeleted, List<SalesOrder> salesOrders, List<PurchaseHistory> purchaseHistory) {
			super();
			this.username = username;
			this.password = password;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.isDeleted = isDeleted;
			this.salesOrders = salesOrders;
			this.purchaseHistory = purchaseHistory;
		}

		public int getCustomerId() {
			return customerId;
		}
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public IsDeleted getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(IsDeleted isDeleted) {
			this.isDeleted = isDeleted;
		}

		public List<SalesOrder> getSalesOrders() {
			return salesOrders;
		}

		public void setSalesOrders(List<SalesOrder> salesOrders) {
			this.salesOrders = salesOrders;
		}

		public List<PurchaseHistory> getPurchaseHistory() {
			return purchaseHistory;
		}

		public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
			this.purchaseHistory = purchaseHistory;
		}
}
