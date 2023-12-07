package com.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_table")

public class ProductEntity 
{
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_category")
	private String productCategory;
	
	@Column(name= "licence_key")
	private String licenceKey;
	
	@Column(name = "product_rating")
	private int rating;
	@Column(name = "product_size")
	private int size;
	

    
}
