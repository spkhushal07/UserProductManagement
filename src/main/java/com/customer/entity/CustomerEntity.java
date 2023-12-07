package com.customer.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name="customer_entity")

public class CustomerEntity 
{
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	
	@Column(name = "first_name")
	private String userFirstName;
	@Column(name = "last_name")
	private String userLastName;
	@Column(name = "username")
	private String userName;
	private String password;
	private String email;
	@Column(name = "mobile_number")

	private String mobileNumber;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "product_allot", 
							joinColumns = @JoinColumn(name = "user_id"), 
							inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products = new ArrayList<>();	
    @CreationTimestamp
	@Column(name = "user_created")
	
	private LocalDateTime userCreated;
	
	@CreationTimestamp
	@Column(name = "user_last_login")
	private LocalDateTime userLastLogin;

	public void setProducts(ProductEntity productById) {
		products.add(productById);
		
	}
	
	}
