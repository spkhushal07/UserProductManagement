package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.entity.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {


	public CustomerEntity findByUserName(String userId);

	public CustomerEntity findByUserNameAndPassword(String userName, String password);

}
