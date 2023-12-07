package com.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.ProductEntity;
import com.customer.repository.ProductRepo;

@Service
public class ProductService 
{
	@Autowired
	ProductRepo productRepo;
//for adding product into db;
	public String addProduct(com.customer.dto.ProductDto productDto) 
	{
		if(productRepo.existsById(productDto.getProductId()))
		{
			return null;
		}
		else
		{
		ProductEntity entity=new ProductEntity();
		entity.setProductId(productDto.getProductId());
		entity.setProductName(productDto.getProductName());
		entity.setProductCategory(productDto.getProductCategory());
		entity.setLicenceKey(productDto.getLicenceKey());
		entity.setRating(productDto.getRating());
		entity.setSize(productDto.getSize());
		
		productRepo.save(entity);
		return "Product Added Succesfuly";
		}
	}
//fetching product data from db
	public List<ProductEntity> getProduct() 
	{
		List<ProductEntity> data=productRepo.findAll();
		return data;
	}
//fetching product data from db based on id;

	public String deleteId(int id) 
	{
		if(productRepo.existsById(id))
		{
			productRepo.deleteById(id);
		}
		else
		{
			return null;
		}
		return "Delete Succesfuly";
	}

	public ProductEntity getProductById(int id) {

		Optional<ProductEntity> data =productRepo.findById(id);
		if(data.isPresent())
		{
			return data.get();
		}
		else
		{
			return null;
		}
	}
	
	public ProductEntity updateProduct(int id, com.customer.dto.ProductDto productDto) {
		Optional<ProductEntity> data=productRepo.findById(id);
		if(data.isPresent())
		{
			ProductEntity entity=data.get();
			entity.setProductId(id);
			entity.setProductCategory(entity.getProductCategory());
			entity.setProductName(entity.getProductName());
			entity.setLicenceKey(productDto.getLicenceKey());
			entity.setRating(productDto.getRating());
			entity.setSize(productDto.getSize());
			
			
			return productRepo.save(entity);
		}
		return null;
	}
}