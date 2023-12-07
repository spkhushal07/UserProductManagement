package com.customer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto 
{
	
	private int productId;
	
	private String productName;
	
	private String productCategory;
	
	private String licenceKey;
	
	private int rating;
	
	private int size;
}
