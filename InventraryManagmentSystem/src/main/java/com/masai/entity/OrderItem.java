package com.masai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItem {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "order_item_id")
	    private int orderItemId;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private SalesOrder salesOrder;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

	    private int quantity;
	    @Column(name = "unit_price")
	    private double unitPrice;
		public OrderItem(SalesOrder salesOrder, Product product, int quantity, double unitPrice) {
			super();
			this.salesOrder = salesOrder;
			this.product = product;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}
		public OrderItem() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getOrderItemId() {
			return orderItemId;
		}
		public SalesOrder getSalesOrder() {
			return salesOrder;
		}
		public void setSalesOrder(SalesOrder salesOrder) {
			this.salesOrder = salesOrder;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
	    
}
