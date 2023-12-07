package com.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductController {
	@Autowired
	com.customer.service.ProductService productService;

	@PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestBody com.customer.dto.ProductDto dto) 
	{
    		String result=productService.addProduct(dto);
    		if(result !=null)
    		{
    			String message="Product Added Succesfully";
    			return new ResponseEntity<>(message,HttpStatus.OK);
    		}
    		else
    		{
    			String message="Product Already Exist";
    			return new ResponseEntity<>( message,HttpStatus.CONFLICT);
    		}
    }

	@GetMapping("/getproduct")
	public List<com.customer.entity.ProductEntity> getProduct() 
	{
		List<com.customer.entity.ProductEntity> data = productService.getProduct();
		 
		return data;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteId(@PathVariable int id)
	{
		String result=productService.deleteId(id);
		if(result !=null)
		{
			String message="Deleted Successfuly";
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		else
		{
			String message="Product Not Exist";
			return new ResponseEntity<>( message,HttpStatus.NOT_FOUND);
		}		
	}	
	@GetMapping("/getproduct/{id}")
	public ResponseEntity<com.customer.entity.ProductEntity> getProductById(@PathVariable int id)
	{
		com.customer.entity.ProductEntity result =(com.customer.entity.ProductEntity) productService.getProductById(id);
		if(result !=null)
		{
			return new ResponseEntity<com.customer.entity.ProductEntity>(result, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<com.customer.entity.ProductEntity>( HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<com.customer.entity.ProductEntity> updateProduct(@PathVariable int id,@RequestBody com.customer.dto.ProductDto productDto)
	{
		com.customer.entity.ProductEntity result =productService.updateProduct(id,productDto);
		if(result !=null)
		{
			return new ResponseEntity<com.customer.entity.ProductEntity>(result, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<com.customer.entity.ProductEntity>( HttpStatus.NOT_FOUND);
		}
	}

}
