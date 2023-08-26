package com.masai.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    @Enumerated
    @Column(name="is_deleted")
    private IsDeleted isDeleted;
    @OneToMany(mappedBy = "admin")
    private List<Product> products;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminId, String userName, String password, String name, String email, String phone, String address,
			IsDeleted isDeleted, List<Product> products) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isDeleted = isDeleted;
		this.products = products;
	}
	public Admin( String username, String password, String name, String email, String phone, String address,
			IsDeleted isDeleted, List<Product> products) {
		super();
		this.userName = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isDeleted = isDeleted;
		this.products = products;
	}
	public int getAdminId() {
		return adminId;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
    
}
