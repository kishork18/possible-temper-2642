package com.masai.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SalesOrders")
public class SalesOrder {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "order_id")
	    private int orderId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;
        @Column(name = "order_date")
	    private LocalDate orderDate;
        @Column(name = "total_amount")
	    private double totalAmount;
        @Enumerated
	    private OrderStatus orderStatus;
	    @Enumerated
	    @Column(name="is_deleted")
	    private IsDeleted isDeleted;

	    @OneToMany(mappedBy = "salesOrder")
	    private List<OrderItem> orderItems;

		public SalesOrder() {
			super();
			// TODO Auto-generated constructor stub
		}

		public SalesOrder(Customer customer, LocalDate orderDate, double totalAmount, OrderStatus orderStatus,
				IsDeleted isDeleted, List<OrderItem> orderItems) {
			super();
			this.customer = customer;
			this.orderDate = orderDate;
			this.totalAmount = totalAmount;
			this.orderStatus = orderStatus;
			this.isDeleted = isDeleted;
			this.orderItems = orderItems;
		}

		public int getOrderId() {
			return orderId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public LocalDate getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDate orderDate) {
			this.orderDate = orderDate;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public OrderStatus getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(OrderStatus orderStatus) {
			this.orderStatus = orderStatus;
		}

		public IsDeleted getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(IsDeleted isDeleted) {
			this.isDeleted = isDeleted;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}
	    
}
