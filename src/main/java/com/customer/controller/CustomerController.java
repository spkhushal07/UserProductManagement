package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDto;
import com.customer.dto.CustomerLogin;
import com.customer.entity.CustomerEntity;
import com.customer.service.CustomerService;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/registeruser")
	public ResponseEntity<String> registerUser(@RequestBody CustomerDto customerDto)
	{
		String message=customerService.registerUser(customerDto);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	@GetMapping("/getuser")
	public List<CustomerEntity> getUser()
	{
		List<CustomerEntity> customerEntity=customerService.getuser();
		return customerEntity;
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<CustomerEntity> getUserByUserId(@PathVariable String userId )
	{
		CustomerEntity cust=customerService.getUserByUserId(userId);
		if(cust!=null)
		{
			return new ResponseEntity<CustomerEntity>(cust,HttpStatus.OK);
		}
		else
			return new ResponseEntity<CustomerEntity>(HttpStatus.NOT_FOUND);

	}
	
	@PostMapping("/login")
	public ResponseEntity<CustomerEntity> login(@RequestBody CustomerLogin customerLogin)
	{
		CustomerEntity data=customerService.login(customerLogin.getUserName(), customerLogin.getPassword());
		if(data !=null)
		{
			return new ResponseEntity<CustomerEntity>(data,HttpStatus.OK);
		}
		else
			return new ResponseEntity<CustomerEntity>(HttpStatus.NOT_FOUND);
	}
}
