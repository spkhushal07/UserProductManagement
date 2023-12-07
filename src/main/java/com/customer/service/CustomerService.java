package com.customer.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.CustomerDto;
import com.customer.entity.CustomerEntity;
import com.customer.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	ProductService productService;
	public String registerUser(CustomerDto Dto) {
		
		CustomerEntity entity=new CustomerEntity();
		entity.setUserFirstName(Dto.getUserFirstName());
		entity.setUserLastName(Dto.getUserLastName());
		entity.setUserName(Dto.getUserName());
		entity.setPassword(Dto.getPassword());
		entity.setEmail(Dto.getEmail());
		entity.setMobileNumber(Dto.getMobileNumber());
		for(int id:Dto.getProducts())
		{
		entity.setProducts(productService.getProductById(id));		
		}
		customerRepo.save(entity);
		return "Customer Id: "+entity.getUserId();
	}
	public List<CustomerEntity> getuser() 
	{
		
		return customerRepo.findAll();
	}
	public CustomerEntity getUserByUserId(String userId) {

		CustomerEntity data=customerRepo.findByUserName(userId);
		
		if(data.equals(null))
		{
			return null;
		}
		return data;
	}
	public CustomerEntity login(String userName, String password) {
		CustomerEntity data=customerRepo.findByUserNameAndPassword(userName,password);
		if(!data.equals(null))
		{
			data.setUserLastLogin(LocalDateTime.now());
			return data;
		}
		return null;
	}

}
